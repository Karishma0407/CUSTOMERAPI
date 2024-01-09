package dev.webservices.customerapi.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.addresses.Entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findByName(String name);

}
