package com.example.greetingapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Greeting {

    private Long id;
    private String message;

}
