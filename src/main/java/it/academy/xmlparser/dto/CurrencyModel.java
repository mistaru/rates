package it.academy.xmlparser.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import it.academy.xmlparser.enums.CurrencyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JacksonXmlRootElement(localName = "Currency")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyModel {

    @JacksonXmlProperty(localName = "ISOCode", isAttribute = true)
    @Enumerated(EnumType.STRING)
    CurrencyType isoCode;

    @JacksonXmlProperty(localName = "Nominal")
    Integer nominal;

    @JacksonXmlProperty(localName = "Value")
    BigDecimal value;

    public void setValue(String value) {
        value = value.replace(',', '.');
        this.value = new BigDecimal(value);
    }
}