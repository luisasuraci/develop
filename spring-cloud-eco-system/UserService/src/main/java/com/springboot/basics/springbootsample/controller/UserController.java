package com.springboot.basics.springbootsample.controller;

import com.springboot.basics.springbootsample.entity.User;
import com.springboot.basics.springbootsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/addUser")
    void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
