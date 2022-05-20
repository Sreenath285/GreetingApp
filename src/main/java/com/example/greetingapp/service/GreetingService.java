package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public String getMessage() {
        return "Hello world !!";
    }

    @Override
    public String getGreetingMessage(String fName, String lName) {
        return "Hello " + fName + " " + lName;
    }

    @Override
    public String postGreetingMessage(User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @Override
    public Greeting addGreeting(User user) {
        String greeting = String.format(template, (user.toString().isEmpty()) ? "Hello world" : user.toString());
        return greetingRepository.save(new Greeting((int) counter.incrementAndGet(), greeting));
    }

    @Override
    public Greeting getGreetingByID(Integer id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting updateGreeting(Greeting greeting) {
        if (greetingRepository.findById(greeting.getId()).isPresent())
            return greetingRepository.save(greeting);
        else
            return new Greeting(-1, "Greeting NOT FOUND");
    }

    @Override
    public void deleteGreeting(Integer id) {
        greetingRepository.deleteById(id);
    }
}
