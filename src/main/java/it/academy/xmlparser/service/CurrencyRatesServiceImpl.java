package it.academy.xmlparser.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.academy.xmlparser.dto.CurrencyRatesModel;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrencyRatesServiceImpl implements CurrencyRatesService {
    RestTemplate restTemplate;
    XmlMapper xmlMapper;

    public CurrencyRatesServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.xmlMapper = new XmlMapper();
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
        } catch (Exception e) {
            log.error("saveModelFromApi()", e);
        }
        return model;
    }

}