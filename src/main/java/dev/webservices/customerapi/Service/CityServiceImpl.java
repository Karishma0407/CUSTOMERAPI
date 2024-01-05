package dev.webservices.customerapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.customerapi.Entity.City;
import dev.webservices.customerapi.Entity.Country;
import dev.webservices.customerapi.Repository.CityRepository;
import dev.webservices.customerapi.Repository.CountryRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    // To save city with the country
    @Override
    public City save(City city) {

        // do we have country?
        if (city.getCountry() != null) {
            // if yes, save it
            // To check if the given country already present
            Optional<Country> existingCountry = countryRepository.findByName(city.getCountry().getName());
            if (existingCountry.isPresent()) {
                System.out.println("Country already present!");
                city.setCountry(existingCountry.get());
            } else {
                countryRepository.save(city.getCountry());
            }
        }

        // To check if the given city already present
        Optional<City> existingCity = cityRepository.findByName(city.getName());
        if (existingCity.isPresent()) {
            System.out.println("City already present!");
            return null;
        } else {
            return cityRepository.save(city);
        }

    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public void update(City city) {
        Optional<City> customerCity = cityRepository.findById(city.getId());
        customerCity.ifPresent(Newcity -> cityRepository.save(Newcity));
    }

    @Override
    public void delete(Long id) {
        Optional<City> customerCity = cityRepository.findById(id);
        customerCity.ifPresent(city -> cityRepository.delete(city));
    }

}
