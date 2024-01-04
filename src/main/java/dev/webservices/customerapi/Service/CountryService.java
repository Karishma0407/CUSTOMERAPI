package dev.webservices.customerapi.Service;

import java.util.Optional;

import dev.webservices.customerapi.Entity.Country;

public interface CountryService {

    Country save(Country country);

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    void update(Long id);

    void delete(Long id);

}
