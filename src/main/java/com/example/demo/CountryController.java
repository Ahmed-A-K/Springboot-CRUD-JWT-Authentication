package com.example.demo;

import com.example.demo.service.CountryService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.request.CountryRequest;

@RestController
@RequestMapping(path="/country")
public class CountryController {
    @Autowired
    CountryService countryService;
    @GetMapping(path="/apiCall")
    public @ResponseBody JsonNode callApi() {
        return countryService.callApi("Pakistan");
    }

    @PostMapping(path="/saveCountry")
    public @ResponseBody ResponseEntity<Object> saveCountry(@Valid @RequestBody CountryRequest countryRequest) {
        return countryService.saveCountry(countryRequest);
    }
}
