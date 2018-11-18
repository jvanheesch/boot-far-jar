package com.github.jvanheesch.fat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean<Filter1> filter1() {
        FilterRegistrationBean<Filter1> registration = new FilterRegistrationBean<>();
        registration.setFilter(new Filter1());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
