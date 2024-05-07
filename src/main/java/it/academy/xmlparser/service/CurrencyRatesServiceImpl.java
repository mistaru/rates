package it.academy.xmlparser.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.academy.xmlparser.dto.CurrencyModel;
import it.academy.xmlparser.dto.CurrencyRatesModel;
import it.academy.xmlparser.entity.Currency;
import it.academy.xmlparser.entity.CurrencyRates;
import it.academy.xmlparser.repo.CurrencyRatesRepo;
import it.academy.xmlparser.repo.CurrencyRepo;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrencyRatesServiceImpl implements CurrencyRatesService {
    RestTemplate restTemplate;
    XmlMapper xmlMapper;
    CurrencyRepo currencyRepo;
    CurrencyRatesRepo currencyRatesRepo;

    public CurrencyRatesServiceImpl(RestTemplate restTemplate, CurrencyRepo currencyRepo, CurrencyRatesRepo currencyRatesRepo) {
        this.restTemplate = restTemplate;
        this.xmlMapper = new XmlMapper();
        this.currencyRepo = currencyRepo;
        this.currencyRatesRepo = currencyRatesRepo;
    }

    @Override
    public CurrencyRatesModel getModelFromApi() throws Exception {
        String xml = restTemplate.getForObject("https://www.nbkr.kg/XML/daily.xml", String.class);
        System.out.println(xml);
        return xmlMapper.readValue(xml, CurrencyRatesModel.class);
    }

    @Override
    public CurrencyRatesModel saveModelFromApi() {
        var model = new CurrencyRatesModel();
        try {
            model = getModelFromApi();

            List<CurrencyModel> currencyModelList = model.getCurrencyModelList();

            List<Currency> currencyList = new ArrayList<>();

            for(CurrencyModel currencyModel : currencyModelList){
                Currency currency = new Currency(null,
                        currencyModel.getIsoCode(),
                        currencyModel.getNominal(),
                        currencyModel.getValue());
                currencyList.add(currency);
                currencyRepo.save(currency);
            }

            CurrencyRates currencyRates = new CurrencyRates(null,
                    LocalDateTime.now(),
                    model.getName(),
                    model.getDate(),
                    currencyList);

            currencyRatesRepo.save(currencyRates);


        } catch (Exception e) {
            log.error("saveModelFromApi()", e);
        }
        return model;
    }

}