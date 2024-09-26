package com.javacountries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

// STRETCH
@RestController
@RequestMapping("/age")
public class AgeController
{
    // localhost:8080/age/age/{age}
    @GetMapping(value = "age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getAgeEqualToOrGreaterThan(@PathVariable int age)
    {
        ArrayList<Country> returnAgeEqualOrGreaterThan = JavaCountriesApplication.theCountryList
                .findCountries(c -> c.getAge() >= age);
        returnAgeEqualOrGreaterThan.sort(Comparator.comparingInt(Country::getAge));
//        returnAgeEqualOrGreaterThan.sort((c1, c2) -> (int)(c1.getAge() - c2.getAge()));
        return new ResponseEntity<>(returnAgeEqualOrGreaterThan, HttpStatus.OK);
    }

    //localhost:8080/age/min
    @GetMapping(value = "min", produces = {"application/json"})
    public ResponseEntity<?> getMinAge()
    {
        ArrayList<Country> returnMinAge = JavaCountriesApplication.theCountryList.countryList;
        returnMinAge.sort(Comparator.comparingInt(Country::getAge));
//        returnMinAge.sort((c1, c2) -> (int)(c1.getAge() - c2.getAge()));
        return new ResponseEntity<>(returnMinAge.get(0), HttpStatus.OK);
    }

    //localhost:8080/age/max
    @GetMapping(value = "max", produces = {"application/json"})
    public ResponseEntity<?> getMaxAge()
    {
        ArrayList<Country> returnMaxAge = JavaCountriesApplication.theCountryList.countryList;
        returnMaxAge.sort((c1, c2) -> (c2.getAge() - c1.getAge()));
//        returnMaxAge.sort((c1, c2) -> (int)(c2.getAge() - c1.getAge()));
        return new ResponseEntity<>(returnMaxAge.get(0), HttpStatus.OK);
    }

    //STRETCH STRETCH
    //localhost://8080/age/median
    @GetMapping(value ="median", produces = {"application/json"})
    public ResponseEntity<?> getMedianAge()
    {
        ArrayList<Country> returnCountryMedianAge = JavaCountriesApplication.theCountryList.countryList;
        returnCountryMedianAge.sort(Comparator.comparingInt(Country::getAge));
//        returnCountryMedianAge.sort((c1, c2) -> (int)(c1.getAge() - c2.getAge()));
        int medianAge;
        medianAge = returnCountryMedianAge.size() / 2;
        return new ResponseEntity<>(returnCountryMedianAge.get(medianAge), HttpStatus.OK);
    }

}
