package com.cloud.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-conversion-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getExhangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
