package it.academy.xmlparser.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.academy.xmlparser.dto.CurrencyModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


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
    LocalDateTime createDate;
    String name;
    LocalDate date;
    @ManyToMany
    List<Currency> currencyModelList;

    // Дальше нужно самим дополнить поля
}
