package com.javacountries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    // localhost:8080/population/size/{people}
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getPopulationEqualOrGreaterThan(@PathVariable int number)
    {
        ArrayList<Country> returnPopulationEqualOrGreaterThan = JavaCountriesApplication.theCountryList
                .findCountries(c -> c.getPopulation() >= number);
        returnPopulationEqualOrGreaterThan.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(returnPopulationEqualOrGreaterThan, HttpStatus.OK);
    }

    // localhost:8080/population/min
    @GetMapping(value = "min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestPopulation()
    {
        ArrayList<Country> returnSmallestPopulation = JavaCountriesApplication.theCountryList.countryList;
        returnSmallestPopulation.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(returnSmallestPopulation.get(0), HttpStatus.OK);
    }

    // localhost:8080/population/max
    @GetMapping(value = "max", produces = {"application/json"})
    public ResponseEntity<?> getLargestPopulation()
    {
        ArrayList<Country> returnLargestPopulation = JavaCountriesApplication.theCountryList.countryList;
        returnLargestPopulation.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(returnLargestPopulation.get(0), HttpStatus.OK);
    }

    // STRETCH
    // localhost:8080/population/median
    @GetMapping(value = "median", produces = {"application/json"})
    public ResponseEntity<?> getCountryMedianPopulation()
    {
        ArrayList<Country> returnCountryMedianPopulation = JavaCountriesApplication.theCountryList.countryList;
        returnCountryMedianPopulation.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        int median;
        median = returnCountryMedianPopulation.size() / 2;
        return new ResponseEntity<>(returnCountryMedianPopulation.get(median), HttpStatus.OK);
    }

}

