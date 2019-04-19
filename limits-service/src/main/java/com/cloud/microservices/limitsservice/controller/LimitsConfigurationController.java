package com.cloud.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.microservices.limitsservice.bean.LimitConfiguration;
import com.cloud.microservices.limitsservice.configuration.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(path = "/limits")
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	
	@GetMapping
	public LimitConfiguration getLimitsFromConfiguartion() {
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
	@GetMapping("fault-tolerance")
	@HystrixCommand(fallbackMethod="fallbackgetLimitsFromConfiguartionTwo")
	public LimitConfiguration getLimitsFromConfiguartionTwo() {
		throw new RuntimeException("not available");
	}
	
	public LimitConfiguration fallbackgetLimitsFromConfiguartionTwo() {
		return new LimitConfiguration(1, 50);
	}
}
