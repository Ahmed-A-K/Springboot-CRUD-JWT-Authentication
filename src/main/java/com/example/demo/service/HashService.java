package com.example.demo.service;


import com.example.demo.request.DemoRequest;
import org.springframework.stereotype.Service;

//Google hashing dependency
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

@Service
public class HashService implements IHashService{

    @Override
    public String convertToHash(DemoRequest demoRequest) {

        // convert object to string
        String convert = String.valueOf(demoRequest.getEmail() + demoRequest.getName());
        String sha256hex = Hashing.sha256().hashString(convert, StandardCharsets.UTF_8).toString();
        return sha256hex;

    }

}
