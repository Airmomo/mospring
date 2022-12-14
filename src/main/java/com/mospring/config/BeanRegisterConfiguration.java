package com.mospring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 这里主要作用于注册其他框架提供的Bean类
 */
@Configuration
public class BeanRegisterConfiguration {

    /**
     * 添加记住我功能用于存放Token记录的数据库仓库
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(@Autowired DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        // repository.setCreateTableOnStartup(true);
        // 在数据库中自动创建存储Token的表，如果表不存在，则在第一次启动时会自动创建表
        // 第一次启动后建议关闭该功能，否则表重复创建将发生错误。
        repository.setDataSource(dataSource);
        return repository;
    }

}
