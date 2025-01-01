package com.sdta.service.imple;

import com.sdta.dto.CountryDto;
import com.sdta.mapper.CountryMapper;
import com.sdta.model.Country;
import com.sdta.repository.CountryRepository;
import com.sdta.service.CountryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryServiceImpleTest {

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private CountryMapper countryMapper;

    @InjectMocks
    private CountryServiceImple countryService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchByIsoCode() {
        Country country = new Country();
        country.setId(1);
        country.setIsoCode("US");

        when(countryRepository.findByIsoCode("US")).thenReturn(Optional.of(country));
        when(countryMapper.countryDtoMapper(country)).thenReturn(new CountryDto(1, "US"));

        CountryDto result = countryService.searchByIsoCode("US");

        assertEquals("US", result.name());
    }


    @Test
    void testSearchByIsoCodeNotFound() {
        String isoCode = "XYZ"; // An isoCode that doesn't exist in the repository

        when(countryRepository.findByIsoCode(isoCode.toUpperCase())).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            countryService.searchByIsoCode(isoCode);
        });


        assertEquals("Country with Iso XYZ was not found", exception.getReason());

        // Verify that the repository was called once
        verify(countryRepository, times(1)).findByIsoCode(isoCode.toUpperCase());
    }
}