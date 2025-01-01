package com.sdta.service.imple;


import com.sdta.dto.CountryDto;
import com.sdta.mapper.CountryMapper;
import com.sdta.model.Country;
import com.sdta.repository.CountryRepository;
import com.sdta.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImple implements CountryService {

    private final CountryRepository countryRepository;
    private  final CountryMapper countryMapper;


    @Override
    public CountryDto searchByIsoCode(String isoCode) {
//        H2 Database's default is case-sensitive
        isoCode = isoCode.toUpperCase();

        Optional<Country> optional = countryRepository.findByIsoCode(isoCode);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Country with Iso %s was not found", isoCode)
            );

        }
        Country country = optional.get();

        return countryMapper.countryDtoMapper(country);
    }

}
