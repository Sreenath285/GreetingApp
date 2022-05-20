package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

public interface IGreetingService {

    Greeting addGreeting(User user);

    Greeting getGreetingByID(Integer id);


}
