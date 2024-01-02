package dev.webservices.customerapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.customerapi.Entity.Country;
import dev.webservices.customerapi.Repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            countryRepository.save(country.get());
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            countryRepository.delete(country.get());
        }
    }

}
