package com.example.Tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Autowired
    private RegistrationRepository repository; // Use 'repository' here, not 'registrationRepository'

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        // Create a new Registration object and set the values from the form
        Registration registration = new Registration();
        registration.setName(name);
        registration.setEmail(email);
        registration.setMessage(message);
        registration.setCreatedAt(LocalDateTime.now());

        // Save the registration object to the database
        repository.save(registration); // Use 'repository' to save

        // Return a view or redirect to a confirmation page
        return "registration-success";  // A view or page indicating success
    }
}