package com.example.demo.service;

import com.example.demo.CountryRepository;
import com.example.demo.Entity.Country;
import com.example.demo.Response;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.request.CountryRequest;

@Service
public class CountryService implements ICountryService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public ResponseEntity<Object> saveCountry(CountryRequest countryRequest) {
        JsonNode obj = callApi(countryRequest.getName());

        String name = String.valueOf(obj.findValue("common")).replaceAll("^\"|\"$", "");

        String capital = String.valueOf(obj.findValue("capital")).replace("[","").replace("]","").replaceAll("^\"|\"$", "");

        String currency = String.valueOf(obj.findValue("currencies").findValue("name")).replaceAll("^\"|\"$", "");


        String region = String.valueOf(obj.findValue("region")).replaceAll("^\"|\"$", "");

        Country country = Country.builder().name(name).capital(capital
        ).currency(currency).region(region).build();
        countryRepository.save(country);
        return Response.generateResponse("Country added successfully", HttpStatus.OK,country);
    }

    @Override
    public JsonNode callApi(String name) {
        String URI = String.format("https://restcountries.com/v3.1/name/%s",name);
        RestTemplate restTemplate = new RestTemplate();
        JsonNode str = restTemplate.getForObject(URI, JsonNode.class);
        return str;
    }
}
