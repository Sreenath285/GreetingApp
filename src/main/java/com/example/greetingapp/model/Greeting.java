package com.example.greetingapp.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "greeting")
public class Greeting {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    private String message;

}
