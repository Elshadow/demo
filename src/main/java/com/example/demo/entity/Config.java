package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
// @ConfigurationProperties(prefix = "test")
// @PropertySource("classpath:test.properties")
public class Config {

    private String name;

    private String environment;

    private List<String> servers = new ArrayList<String>();

    private BigDecimal number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal num) {
        this.number = num;
    }

}