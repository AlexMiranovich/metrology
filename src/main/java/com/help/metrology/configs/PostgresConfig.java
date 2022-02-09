package com.help.metrology.configs;

import com.help.metrology.properties.v1.PostgresProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PostgresConfig {

    private final PostgresProperties postgresProperties;

    public PostgresConfig(PostgresProperties postgresProperties) {
        this.postgresProperties = postgresProperties;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(postgresProperties.getUrl());
        dataSource.setUsername(postgresProperties.getUserName());
        dataSource.setPassword(postgresProperties.getPassword());
        return dataSource;
    }
}
