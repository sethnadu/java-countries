package com.javacountries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController
{
    //localhost:8080/names/all
    @GetMapping(value = "/all", produces = {"application/json"})
            public ResponseEntity<?> getAllCountries()
    {
        ArrayList<Country> returnAllCountries = JavaCountriesApplication.theCountryList.countryList;
        returnAllCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(returnAllCountries, HttpStatus.OK);

    }

    // localhost:8080/names/start/{letter}
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLetter(@PathVariable char letter)
    {
        ArrayList<Country> returnCountriesByLetter = JavaCountriesApplication.theCountryList
                .findCountries(c -> (c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter)));
        returnCountriesByLetter.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(returnCountriesByLetter, HttpStatus.OK);
    }

    // localhost:8080/names/size/{number}
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByGivenLength(@PathVariable int number)
    {
        ArrayList<Country> returnCountriesByGivenLength = JavaCountriesApplication.theCountryList
                .findCountries(c -> (c.getName().length() == number));
        returnCountriesByGivenLength.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(returnCountriesByGivenLength, HttpStatus.OK);
    }

}
