package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingRestController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>(greetingService.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/getGreeting")
    public ResponseEntity<String> getGreeting(@RequestParam(value = "firstName", defaultValue = "world") String fName,
                                              @RequestParam(value = "lastName", defaultValue = "") String lName) {
        return new ResponseEntity<String>(greetingService.getGreetingMessage(fName, lName), HttpStatus.OK);
    }

    @PostMapping("/postGreeting")
    public ResponseEntity<String> postGreeting(@RequestBody User user) {
        return new ResponseEntity<String>(greetingService.postGreetingMessage(user.getFirstName(), user.getLastName()),
                                          HttpStatus.OK);
    }
}
