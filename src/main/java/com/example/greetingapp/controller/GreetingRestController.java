package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.GreetingService;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingRestController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService iGreetingService;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>(iGreetingService.getMessage(), HttpStatus.OK);
    }

    @PostMapping("/postGreeting")
    public ResponseEntity<String> postGreeting(@RequestBody User user) {
        return new ResponseEntity<String>(iGreetingService.postGreetingMessage(user), HttpStatus.OK);
    }

    @GetMapping("/saveGreeting")
    public Greeting getGreeting(@RequestParam(value = "firstName", defaultValue = "world") String fName,
                                @RequestParam(value = "lastName", defaultValue = "") String lName) {
        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return iGreetingService.addGreeting(user);
    }

    @GetMapping("/getGreetingByID")
    public Greeting getGreetingByID(@RequestParam(name = "id") Integer id) {
        return iGreetingService.getGreetingByID(id);
    }

    @GetMapping("/getAllGreetings")
    public List<Greeting> getAllGreetings() {
        return iGreetingService.getAllGreetings();
    }

    @PutMapping("/editGreeting")
    public Greeting updateGreeting(@RequestBody Greeting greeting) {
        return iGreetingService.updateGreeting(greeting);
    }

    @DeleteMapping("/deleteGreeting")
    public void deleteGreeting(@RequestParam(name = "id") Integer id) {
        iGreetingService.deleteGreeting(id);
    }
}
