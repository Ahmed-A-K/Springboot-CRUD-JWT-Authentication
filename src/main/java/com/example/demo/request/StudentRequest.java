package com.example.demo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
public class StudentRequest {
    @NotBlank(message = "Invalid Name: Empty Name")
    @NotNull(message = "Invalid Name: Name is Null")
    String name;

    @Email(message = "Invalid Email")
    String email;

}
