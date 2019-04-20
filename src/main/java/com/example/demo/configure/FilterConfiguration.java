package com.example.demo.configure;

import javax.servlet.Filter;

import com.example.demo.filter.SampleFilter2;
import com.example.demo.filter.SampleFilter3;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<Filter> SampleFilter2RegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>(new SampleFilter2());
        bean.addUrlPatterns("*");
        bean.setOrder(2);
        bean.setName("SampleFilter2");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> SampleFilter3RegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>(new SampleFilter3());
        bean.addUrlPatterns("*");
        bean.setOrder(1);
        bean.setName("SampleFilter3");
        return bean;
    }

}