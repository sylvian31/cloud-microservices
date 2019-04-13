package com.cloud.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.microservices.limitsservice.bean.LimitConfiguration;
import com.cloud.microservices.limitsservice.configuration.Configuration;

@RestController
@RequestMapping(path = "/limits")
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	
	@GetMapping
	public LimitConfiguration getLimitsFromConfiguartion() {
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
}
