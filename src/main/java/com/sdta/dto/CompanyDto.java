package com.sdta.dto;

public record CompanyDto(
        int id,
        String name,
        CountryDto country
) {}
