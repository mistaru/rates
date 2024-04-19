package it.academy.xmlparser.controller;

import it.academy.xmlparser.dto.CurrencyRatesModel;
import it.academy.xmlparser.service.CurrencyRatesService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/currencyRates")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrencyRatesController {
    CurrencyRatesService service;

    @GetMapping
    public CurrencyRatesModel listAll() {
        return service.saveModelFromApi();
    }

}