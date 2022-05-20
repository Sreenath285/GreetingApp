package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {

    Greeting addGreeting(User user);

    Greeting getGreetingByID(Integer id);

    List<Greeting> getAllGreetings();

    Greeting updateGreeting(Greeting greeting);

     void deleteGreeting(Integer id);
}
