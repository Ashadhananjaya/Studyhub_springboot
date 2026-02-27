package com.studyhub.studyhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.studyhub.studyhub.model.User;
import com.studyhub.studyhub.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

 @PostMapping("/signup")
public User signup(@Valid @RequestBody User user) {
    return userService.register(user);
}

    @GetMapping("/test")
    public String test() {
        return "Auth Controller Working!";
    }
 @PostMapping("/login")
public String login(@RequestBody User user) {

    User existingUser = userService.login(user.getEmail(), user.getPassword());

    if (existingUser != null) {
        return "Login Successful";
    } else {
        return "Invalid Email or Password";
    }
}
}