package com.springboot.basics.springbootsample.service;

import com.springboot.basics.springbootsample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
