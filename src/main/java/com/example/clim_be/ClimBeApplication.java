package com.example.clim_be;

import com.example.clim_be.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Auditing 활성화
@EnableConfigurationProperties(JwtProperties.class)
@EnableFeignClients
@ConfigurationPropertiesScan
public class ClimBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimBeApplication.class, args);
    }

}
