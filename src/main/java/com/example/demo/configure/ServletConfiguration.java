package com.example.demo.configure;

import javax.servlet.Servlet;

import com.example.demo.servlet.ServletSample;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean<Servlet> sampleServletRegistrationBean () {
        return new ServletRegistrationBean<Servlet>(new ServletSample(), "/servlet/sample");
    }

}