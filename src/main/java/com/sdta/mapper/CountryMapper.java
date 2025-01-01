package com.sdta.mapper;


import com.sdta.dto.CountryDto;
import com.sdta.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(source = "isoCode",target = "name")
    CountryDto countryDtoMapper(Country country);

    @Mapping(target = "id", ignore = true)
    Country countryMapper(CountryDto dto);
}
