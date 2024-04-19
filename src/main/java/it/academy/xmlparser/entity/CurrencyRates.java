package it.academy.xmlparser.entity;

import it.academy.xmlparser.dto.CurrencyRatesModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;


@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyRates {

    @Id
    @SequenceGenerator(name = "CURRENCY_RATES_SEQ", sequenceName = "CURRENCY_RATES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CURRENCY_RATES_SEQ")
    Long id;

    Timestamp createDate;

    String name;

    Timestamp currencyDate;

    // Дальше нужно самим дополнить поля
}
