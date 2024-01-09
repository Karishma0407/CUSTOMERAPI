package dev.webservices.customerapi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.addresses.Entity.City;
import dev.webservices.customerapi.Service.CityService;
import dev.webservices.customerapi.Service.CountryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    // Save city in the database
    @PostMapping("/")
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        City savedCity = cityService.save(city);
        return savedCity != null
                ? new ResponseEntity<>(savedCity, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Find city by ID
    @GetMapping("/")
    public ResponseEntity<City> getCity(@RequestParam Long id) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(id);

        // Do we have a city?
        return cityId.map(
                // if yes, send it, with a success code
                value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED))

                // otherwise: send it an erroe code
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete city
    @DeleteMapping("/")
    public ResponseEntity<City> deleteCity(@RequestParam Long id) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(id);
        if (cityId.isPresent()) {
            cityService.delete(id);
            countryService.delete(id);
            return new ResponseEntity<>(cityId.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
