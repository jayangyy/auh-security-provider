/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.services;

import com.kcframework.auhsecurityprovider.domains.EduUser;
import com.kcframework.auhsecurityprovider.domains.Role;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jayang Seurity数据库用户提供程序
 */
@Service
public class EduUserDetailsService implements UserDetailsService {

    protected static Log logger = LogService.getLog(EduUserDetailsService.class);
    @Autowired
    private BaseUserService userDAO;
    private EduUser dbUser;

    public EduUser getDbUser() {
        return dbUser;
    }

    public void setDbUser(EduUser dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        logger.debug("权限框架-加载用户");
//        EduUser dbUser = new EduUser();
//        dbUser.setUsername(username);
        dbUser = userDAO.getUserByName(username);
        /// EduUser dbUser=null;
//        try {
//            dbUser = userDAO.selectOne(username);
//        } catch (SQLException ex) {
//            throw new UsernameNotFoundException("未匹配到用户");
//        }
        if (dbUser == null) {
            throw new UsernameNotFoundException("未匹配到用户");
        }
//        if(baseUser.getStatus()==2)
//        {
//            logger.debug("用户被禁用，无法登陆 用户名:{}", username);
//            throw new UsernameNotFoundException("用户被禁用！");
//        }
//        user = new User(dbUser.getUsername(), dbUser.getPassword()
//                .toLowerCase(), true, true, true, true,
//                getAuthorities(dbUser.getRoles()));
        dbUser.setAccountNonExpired(true);
        dbUser.setAuthorities(getAuthorities(dbUser.getRoles()));
        dbUser.setCredentialsNonExpired(true);
        dbUser.setAccountNonLocked(true);
        dbUser.setEnabled(true);
        return dbUser;
    }

    /**
     * 获得访问角色权限
     *
     * @param access
     * @return
     */
    public Collection<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        //所有的用户默认拥有ROLE_USER权限
        logger.debug("组装用户权限!");
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<SimpleGrantedAuthority>();
        if (roles != null) {
            for (Role role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
            }
        } else {
            //登陆用未分配角色  则默认分配一各匿名角色
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
        }

        return grantedAuthorities;
    }
}
