package com.sdta.mapper;


import com.sdta.dto.CompanyDto;
import com.sdta.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface CompanyMapper {
    CompanyDto CompanyDtoMapper(Company company);

    @Mapping(target = "id", ignore = true)
    Company companyMapper(CompanyDto dto);
}
