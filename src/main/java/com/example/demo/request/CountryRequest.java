package com.example.demo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryRequest {
    @NotBlank(message = "Invalid Name: Enter Name")
    @NotNull(message = "Invalid Name: Name is Null")
    private String name;
}
