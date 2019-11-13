package com.springboot.basics.springbootsample.service;

import com.springboot.basics.springbootsample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
