package dev.webservices.customerapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.customerapi.Entity.City;
import dev.webservices.customerapi.Repository.CityRepository;
import dev.webservices.customerapi.Repository.CountryRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public City save(City city) {

        // do we have country?
        if (city.getCountry() != null) {
            // if yes, save it
            countryRepository.save(city.getCountry());
        }
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<City> customerCity = cityRepository.findById(id);
        customerCity.ifPresent(city -> cityRepository.save(city));
    }

    @Override
    public void delete(Long id) {
        Optional<City> customerCity = cityRepository.findById(id);
        customerCity.ifPresent(city -> cityRepository.delete(city));
    }

}
