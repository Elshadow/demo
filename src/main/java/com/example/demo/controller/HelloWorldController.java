package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.Config;
import com.example.demo.entity.Customize;
import com.example.demo.mapper.CountryLanguageMapper;
import com.example.demo.pojo.CountryLanguage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HelloWorld Controller
 */
@Controller
public class HelloWorldController {

	// @Autowired
	// private Config config;

	// @Autowired
	// private Customize customize;

	@Autowired
	CountryLanguageMapper countryLanguageMapper;

	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
		return "hello";
		// return "hello world, welcome to spring boot with properties " + config.getName() + " " + config.getEnvironment() + " " + config.getServers().toString();
	}

	@RequestMapping("/customize")
	public String customize(Model m) {
		List<CountryLanguage> list = countryLanguageMapper.find10Records();
		m.addAttribute("cl", list);
		return "countrylanguage";
		// return "show properties " + customize.getName() + " " + customize.getNumber();
	}

}