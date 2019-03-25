package com.example.demo.controller;

import com.example.demo.entity.Config;
import com.example.demo.entity.Customize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld Controller
 */
@RestController
public class HelloWorldController {

	@Autowired
	private Config config;

	@Autowired
	private Customize customize;

	@RequestMapping("/")
	public String index() {
		return "hello world, welcome to spring boot with properties " + config.getName() + " " + config.getEnvironment() + " " + config.getServers().toString();
	}

	@RequestMapping("/customize")
	public String customize() {
		return "show properties " + customize.getName() + " " + customize.getNumber();
	}

}