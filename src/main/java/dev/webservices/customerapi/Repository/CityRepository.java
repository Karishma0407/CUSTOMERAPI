package dev.webservices.customerapi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.customerapi.Entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
