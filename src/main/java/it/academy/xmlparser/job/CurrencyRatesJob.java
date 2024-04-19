package it.academy.xmlparser.job;

import it.academy.xmlparser.service.CurrencyRatesService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Component
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CurrencyRatesJob {

    CurrencyRatesService currencyRatesService;

    //@Scheduled(cron = "0 0 9-18 * * *") // каждый день с 9 до 18 с периодом 1 час
//    @Scheduled(fixedDelay = 3000) // каждые 5 секунд
    private void saveCurrencyRates() {
        log.info("startSaveCurrencyRatesJob");
//        currencyRatesService.saveModelFromApi();
        log.info("finishSaveCurrencyRatesJob");
    }
}
