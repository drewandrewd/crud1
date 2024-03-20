package com.example.testservice.model;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class Worker {

    private Long id;

    private String firstName;
    private String lastName;
}
