package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.entity.Config;
import com.example.demo.entity.Customize;
import com.example.demo.mapper.CountryLanguageMapper;
import com.example.demo.pojo.CountryLanguage;
import com.example.demo.vo.Echo;
import com.example.demo.vo.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	private static final String echoTemplate1 = "received %s!";
	private static final String echoTemplate2 = "%s speak to %s \'%s\'";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
		return "hello";
		// return "hello world, welcome to spring boot with properties " +
		// config.getName() + " " + config.getEnvironment() + " " +
		// config.getServers().toString();
	}

	@RequestMapping("/customize")
	public String customize(Model m) {
		List<CountryLanguage> list = countryLanguageMapper.find10Records();
		m.addAttribute("cl", list);
		return "countrylanguage";
		// return "show properties " + customize.getName() + " " +
		// customize.getNumber();
	}

	/**
	 * Get请求，url传参，返回json
	 */
	@RequestMapping(value = "/testget", method = RequestMethod.GET)
	@ResponseBody
	public String testget(@RequestParam(value = "content", required = true, defaultValue = "empty string") String str) {
		return "testget + " + str;
	}

	/**
	 * Get请求，传递url路径参数，返回json
	 */
	@RequestMapping(value = "/testpathvariable/{content}", method = RequestMethod.GET)
	@ResponseBody
	public String testpathvariable(@PathVariable(value = "content", required = true) String ct) {
		return "testpathvariable + " + ct;
	}

	/**
	 * Post请求，参数以Http body的途径提交Json数据
	 */
	@RequestMapping(value = "testpost", method = RequestMethod.POST)
	@ResponseBody
	public Echo testpost(@RequestBody Message message) {
		return new Echo(counter.incrementAndGet(),
				String.format(echoTemplate2, message.getFrom(), message.getTo(), message.getContent()));
	}

	/**
	 * Post请求，参数以Http body的途径提交表单数据
	 */
	@RequestMapping(value = "testpost2", method = RequestMethod.POST)
	@ResponseBody
	public Echo testpost2(@ModelAttribute Message message) {
		return new Echo(counter.incrementAndGet(),
				String.format(echoTemplate2, message.getFrom(), message.getTo(), message.getContent()));
	}

}