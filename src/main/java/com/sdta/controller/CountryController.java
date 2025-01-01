package com.sdta.controller;

import com.sdta.dto.CountryDto;
import com.sdta.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {


    private final   CountryService countryService;

    @GetMapping("/search")
    public ResponseEntity<CountryDto> getCountryByName(@RequestParam String name){
        CountryDto dto = countryService.searchByIsoCode(name);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
