package com.cloud.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@GetMapping(path = "/from/{from}/to/{to}")
	public ExchangeValue getExhangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}

}
