package com.example.springjdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
}
