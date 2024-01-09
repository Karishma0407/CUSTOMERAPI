package dev.webservices.customerapi.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.addresses.Entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    Optional<City> findByName(String name);

}
