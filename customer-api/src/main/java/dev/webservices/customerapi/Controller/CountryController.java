package dev.webservices.customerapi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.addresses.Entity.Country;
import dev.webservices.customerapi.Service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Find country by ID
    @GetMapping("/")
    public Country findCountry(@RequestParam Long id) {

        // Check if the country with the given ID exist
        Optional<Country> countryId = countryService.findById(id);
        if (countryId.isPresent()) {
            return countryService.findById(id).get();
        } else {
            return null;
        }
    }

    // Update country
    @PutMapping("/")
    public String updateCountry(@RequestBody Country country) {

        // Check if the city with the given ID present
        Optional<Country> countryId = countryService.findById(country.getId());
        if (countryId.isPresent()) {
            countryService.update(country);
            return "Country updated successfully!";
        } else {
            return "Country not found!";
        }

    }

    // Delete country
    @DeleteMapping("/")
    public void deleteCountry(@RequestParam Long id) {

        // Check if Country with given ID exist
        Optional<Country> country = countryService.findById(id);
        if (country.isPresent()) {
            countryService.delete(id);
            System.out.println("Country record deleted successfully!");
        } else {
            System.out.println("Country not found!");
        }
    }

}
