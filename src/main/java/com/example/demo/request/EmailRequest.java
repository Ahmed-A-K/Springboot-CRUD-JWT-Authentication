package com.example.demo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {

    @NotNull(message="Invalid Id: Id is null")
    Integer id;

    @Email(message = "Invalid Email")
    String email;
}
