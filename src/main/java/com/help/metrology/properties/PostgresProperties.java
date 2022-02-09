package com.help.metrology.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("spring.datasource")
public class PostgresProperties {

    @Value("url")
    private String url;

    @Value("username")
    private String userName;

    @Value("password")
    private String password;

    @Value("driver-class-name")
    private String driverClassname;
}
