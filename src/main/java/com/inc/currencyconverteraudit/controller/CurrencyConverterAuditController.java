package com.inc.currencyconverteraudit.controller;

import com.inc.currencyconverteraudit.model.ExchangeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class CurrencyConverterAuditController {

    @Autowired
    private final RestTemplate restTemplate;

    public CurrencyConverterAuditController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/transactions")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public ResponseEntity<List<ExchangeTransaction>> listTransactions(){
        return restTemplate
                .exchange("http://currency-convert/transactions", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<ExchangeTransaction>>() {});
    }
}
