package com.example.demo;


import com.example.demo.config.JwtService;
import com.example.demo.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.request.DemoRequest;


import java.util.Objects;

@RestController
@RequestMapping("/check")
public class DemoController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private HashService hashService;

    @GetMapping("/show")
    public ResponseEntity<String> sayHello() {

        return ResponseEntity.ok("Hello from secure endpoint");

    }

    @PostMapping("/TestBody")
    public ResponseEntity<String> sayTestBody(
            @RequestHeader(name="Authorization") String head,
            @RequestHeader(name="Hash") String hash,
            @RequestBody DemoRequest demoRequest) {
        String email = demoRequest.getEmail();
        String jwToken = head.substring(7);
        String retrievedToken  = jwtService.extractUsername(jwToken);

        String calHash = hashService.convertToHash(demoRequest);
        //check if claim(email) in the token matches the email sent with the request body.
        if(!Objects.equals(retrievedToken, email)) {
            return new ResponseEntity<>("Unauthorized user using token", HttpStatus.BAD_REQUEST);
        }

        //check if request header hash and request body hash are same. Inorder to prove uncorrupted request
        if(!Objects.equals(calHash, hash)){
            return new ResponseEntity<>("Users request has been manipulated",HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Hello from Test body");
    }
}

