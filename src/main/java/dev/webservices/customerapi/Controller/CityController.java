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

import dev.webservices.customerapi.Entity.City;
import dev.webservices.customerapi.Entity.Country;
import dev.webservices.customerapi.Service.CityService;
import dev.webservices.customerapi.Service.CountryService;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    // Save city in the database
    @PostMapping("/")
    public String save(@RequestBody City city) {
        cityService.save(city);
        return "Saved successfully!";
    }

    // Find city by ID
    @GetMapping("/")
    public City getCity(@RequestParam Long id) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(id);
        if (cityId.isPresent()) {
            return cityService.findById(id).get();
        } else {
            return null;
        }
    }

    // Update city data
    @PutMapping("/")
    public String update(@RequestBody City city) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(city.getId());
        if (cityId.isPresent()) {
            cityService.update(city);
            return "City updated successfully!";
        } else {
            return "City not found!";
        }

    }

    // Delete city
    @DeleteMapping("/")
    public String delete(@RequestParam Long id) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(id);
        if (cityId.isPresent()) {
            cityService.delete(id);
            return "City record deleted successfully!";
        } else {
            return "City not found!";
        }
    }

    // // Find country by ID
    // @GetMapping("/")
    // public void findCountry(@RequestParam Long id) {
    // countryService.findById(id);
    // System.out.println(cityService.toString());
    // }

    // // Update country
    // @PutMapping("/")
    // public void updateCountry(@RequestParam Long id) {

    // Optional<Country> country = countryService.findById(id);

    // // Check if Country with given ID exist
    // if (country.isPresent()) {
    // countryService.update(id);
    // System.out.println("Country updated successfully!");
    // } else {
    // System.out.println("Country not found!");
    // }
    // }

    // // Delete country
    // @DeleteMapping("/")
    // public void deleteCountry(@RequestParam Long id) {

    // Optional<Country> country = countryService.findById(id);

    // // Check if Country with given ID exist
    // if (country.isPresent()) {
    // countryService.delete(id);
    // System.out.println("Country record deleted successfully!");
    // } else {
    // System.out.println("Country not found!");
    // }
    // }

}
