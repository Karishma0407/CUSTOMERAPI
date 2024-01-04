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
import dev.webservices.customerapi.Service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    // Save city in the database
    @PostMapping("/")
    public String save(@RequestBody City city) {
        cityService.save(city);
        return "Saved successfully!";
    }

    // Find city by ID
    @GetMapping("/")
    public City getCity(@RequestParam Long id) {
        return cityService.findById(id).get();
    }

    // Update city data
    @PutMapping("/")
    public String update(@RequestBody City city) {
        Optional<City> cityId = cityService.findById(city.getId());

        // Check if the city with the given ID present
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
        cityService.delete(id);
        return "City record deleted successfullt!";
    }

}
