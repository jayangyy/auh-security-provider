///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.kcframework.auhsecurityprovider.config;

import com.kcframework.auhsecurityprovider.domains.Resource;
import com.kcframework.auhsecurityprovider.domains.Role;
import com.kcframework.auhsecurityprovider.services.BaseResourcesService;
import com.kcframework.auhsecurityprovider.services.BaseRoleService;
import com.kcframework.auhsecurityprovider.utils.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertySource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 *
 * @author jayan 权限元数据提供类 FilterInvocationSecurityMetadataSource 获取所需权限
 * ci本次存在缓存中 还有一种情况 实时查询 存入SECURITY CONFIG中
 */
@Component
public class EduInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {
    //@Autowired
    private BaseRoleService authDao;
   /// @Autowired
    private BaseResourcesService resDao;
    @Autowired
    private PropertySource propertySourceBean;
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    private String indexUrl = "/index.jsp";
    private final PathMatcher matcher = new AntPathMatcher();
    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    @Autowired
    public EduInvocationSecurityMetadataSourceService(BaseRoleService authDao,BaseResourcesService resDao) {
        super();
//        //使用注解方式的话，只能在构造函数执行完成后才能获得实例
        this.authDao = authDao;
        this.resDao = resDao;
        System.out.println("构造函数!");
        loadResourceDefine();
    }

    // 在Web服务器启动时，提取系统中的所有权限
    private void loadResourceDefine() {
        List<Role> query = authDao.selectAll();//list<role>获取所有角色
        /*
         * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
         * sparta
         */
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        for (Role auth : query) {
            ConfigAttribute ca = new SecurityConfig(auth.getRolename());
            List<Resource> query1 = resDao.getResourceByRoleName(auth.getRolename());//list<resource>获取该角色所有资源
            for (Resource res : query1) {
                String url = res.getRes_url();
                /*
                 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
                 * sparta
                 */
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 判断是否需要过滤
     *
     * @param url
     * @return
     */
    public boolean isIntercept(String url) {
        String[] filterPaths = propertySourceBean.getProperty("security.intercept").toString().split(",");
        for (String filter : filterPaths) {
            if (matcher.match(StringUtil.clearSpace(filter), url) & !matcher.match(indexUrl, url)) {
                return true;
            }
        }

        return false;
    }

    // 根据URL，找到相关的权限配置。
    @Override
    @SuppressWarnings("empty-statement")
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        // object 是一个URL，被用户请求的url。
        String url = ((FilterInvocation) object).getRequestUrl();
        String url1 = ((FilterInvocation) object).getRequestUrl();//带参数URL
        System.out.println("url" + url);
        int firstQuestionMarkIndex = url.indexOf("?");
        List<ConfigAttribute> result = new ArrayList<>();
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        if (propertySourceBean.getProperty("security.ignoring") != null) {
            String[] paths = propertySourceBean.getProperty("security.ignoring").toString().split(",");
            //判断是否符合规则
            for (String path : paths) {
                String temp = StringUtil.clearSpace(path);
                if (matcher.match(temp, url)) {
                    ConfigAttribute attribute = new SecurityConfig("ROLE_ANONYMOUS");
                    result.add(attribute);
                    return result;
                }
            }
        }
        //如果不是拦截列表里的
        if (!isIntercept(url)) {
            ConfigAttribute attribute = new SecurityConfig("ROLE_ANONYMOUS");
            result.add(attribute);
            return result;
        }
        Iterator<String> ite = resourceMap.keySet().iterator();
        Iterator<String> ite1 = resourceMap.keySet().iterator();
        //处理URL 后面带参数链接，默认先返回这个
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (url.equals(resURL)) {
                if (url1.indexOf("?") != -1) {
                    while (ite1.hasNext()) {
                        String resURL1 = ite1.next();
                        if (url1.equals(resURL1)) {
                            //查看是否配有带参数RUL  参数也要算入权限
                            return resourceMap.get(resURL1);
                        }
                    }
                }
                return resourceMap.get(resURL);
            }
        }
        //处理URL 后面无参数链接，后面返回
        while (ite.hasNext()) {
            String resURL = ite.next();

            if (url.equals(resURL)) {
                return resourceMap.get(resURL);
            }
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ///SecurityContextHolder.getContext().setAuthentication(auth);设置登录用户
        //throw new AccessDeniedException("无权限!");//对未加入权限的URL全部实施拦截
        return null;//未加入权限管理URL 暂时不拦截
    }

    @Override
    public boolean supports(Class<?> arg0) {

        return true;
    }
}
