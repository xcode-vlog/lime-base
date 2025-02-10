package com.lime.persistence.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    @Bean
    @DependsOn(value = "jasyptStringEncryptor")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {

        return DataSourceBuilder.create().build();
    }
}
