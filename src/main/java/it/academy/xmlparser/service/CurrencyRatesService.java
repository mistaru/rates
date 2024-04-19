package it.academy.xmlparser.service;

import it.academy.xmlparser.dto.CurrencyRatesModel;

public interface CurrencyRatesService {
    CurrencyRatesModel getModelFromApi() throws Exception;
    public CurrencyRatesModel saveModelFromApi();

}