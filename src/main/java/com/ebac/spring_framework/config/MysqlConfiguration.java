package com.ebac.spring_framework.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MysqlConfiguration {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/ebac?useSSL=false&serverTimezone=UTC")
//                .username("---")
//                .password("---")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
