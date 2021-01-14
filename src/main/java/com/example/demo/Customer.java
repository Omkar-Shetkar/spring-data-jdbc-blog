package com.example.demo;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Customer {

    @Id
    Long id;
    String firstName;
    LocalDate dob;

}
