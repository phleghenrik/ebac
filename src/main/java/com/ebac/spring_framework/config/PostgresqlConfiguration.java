package com.ebac.spring_framework.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostgresqlConfiguration {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/cinema")
//                .username(Criptografia.getUser())
//                .password(Criptografia.getPassword())
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
