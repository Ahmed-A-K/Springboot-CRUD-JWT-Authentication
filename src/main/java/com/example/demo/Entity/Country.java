package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="country_name")
    private String name;

    @Column(name="capital_name")
    private String capital;

    @Column(name="currency")
    private String currency;

    @Column(name="region")
    private String region;
}
