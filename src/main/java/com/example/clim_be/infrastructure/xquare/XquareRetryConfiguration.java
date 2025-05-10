package com.example.clim_be.infrastructure.xquare;


import com.example.clim_be.infrastructure.feign.Custom5xxRetryer;
import com.example.clim_be.infrastructure.feign.CustomErrorDecoder;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class XquareRetryConfiguration {

    @Bean
    public Retryer retryer() {
        return new Custom5xxRetryer();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
