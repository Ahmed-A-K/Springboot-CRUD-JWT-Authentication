package com.example.demo.request;

import jakarta.validation.constraints.Email;
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
public class DemoRequest {
    @NotBlank(message = "Invalid Email: Enter email")
    @NotNull(message = "Invalid Email: Email is Null")
    String email;

    @NotNull(message = "Invalid Name: Name is Null")
    @NotBlank(message = "Invalid Name: Enter name")
    String name;
}

