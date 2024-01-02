package dev.webservices.customerapi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.customerapi.Entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
