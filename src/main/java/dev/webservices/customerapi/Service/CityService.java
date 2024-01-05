package dev.webservices.customerapi.Service;

import java.util.Optional;

import dev.webservices.customerapi.Entity.City;
import dev.webservices.customerapi.Entity.Country;

public interface CityService {

    City save(City city);

    Optional<City> findById(Long id);

    Optional<City> findByName(String name);

    void update(City city);

    void delete(Long id);

}
