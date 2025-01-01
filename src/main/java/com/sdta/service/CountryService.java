package com.sdta.service;


import com.sdta.dto.CountryDto;

public interface CountryService {

    CountryDto searchByIsoCode(String isoCode);

}
