package com.inc.currencyconverteraudit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CurrencyConverterAuditApplication  implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterAuditApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!registry.hasMappingForPattern("/static/**")) {
			registry
					.addResourceHandler("/static/**")
					.addResourceLocations("classpath:/static/", "classpath:/static/js/");
		}
	}
}
