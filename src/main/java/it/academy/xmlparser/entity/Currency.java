package it.academy.xmlparser.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.academy.xmlparser.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    CurrencyType isoCode;
    Integer nominal;
    BigDecimal value;
}
