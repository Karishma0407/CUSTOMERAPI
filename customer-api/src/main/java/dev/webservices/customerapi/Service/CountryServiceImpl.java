package dev.webservices.customerapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.addresses.Entity.Country;
import dev.webservices.customerapi.Repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {

        // Check if a country with the same name already exists
        Optional<Country> existingCountry = countryRepository.findByName(country.getName());
        if (existingCountry.isPresent()) {
            country.setName(existingCountry.get().getName());
        }
        return countryRepository.save(country);

    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public void update(Country country) {
        Optional<Country> countryId = countryRepository.findById(country.getId());
        countryId.ifPresent(value -> countryRepository.save(value));
    }

    @Override
    public void delete(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        country.ifPresent(value -> countryRepository.delete(value));
    }

}
