package it.academy.xmlparser.repo;

import it.academy.xmlparser.entity.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRatesRepo extends JpaRepository<CurrencyRates, Long> {
}
