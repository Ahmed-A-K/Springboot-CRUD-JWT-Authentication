package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import com.example.demo.request.CountryRequest;

public interface ICountryService {
    public abstract ResponseEntity<Object> saveCountry(CountryRequest countryRequest);
    public abstract JsonNode callApi(String name);
}
