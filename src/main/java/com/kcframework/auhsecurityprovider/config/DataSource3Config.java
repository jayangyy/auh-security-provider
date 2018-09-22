package com.kcframework.auhsecurityprovider.config;

import javax.persistence.EntityManager;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import tk.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by summer on 2016/11/25.
 */
@Configuration
//@ConditionalOnClass({ EnableTransactionManagement.class, EntityManager.class })
@MapperScan(basePackages = "com.kcframework.auhsecurityprovider.mappers", sqlSessionTemplateRef = "druidSqlSessionTemplate")
public class DataSource3Config {

    @Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "druidSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("druidDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "druidTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("druidDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "druidSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("druidSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean(name = "mapperCONFIG")
//    public MapperScannerConfigurer testSqlSessionTemplat5e() throws Exception {
//        //com.platform.demand.infrastructure.repository.mappers3
//        MapperScannerConfigurer f = new MapperScannerConfigurer();
//        f.setBasePackage("com.platform.demand.infrastructure.repository.mappers3");
//        return f;
//    }
}
