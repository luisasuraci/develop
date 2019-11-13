package com.springboot.basics.springbootsample.controller;

import com.springboot.basics.springbootsample.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return Arrays.asList(
                new Book(1l, "Shining", "Stephen King"),
                new Book(2l, "Va' dove ti porta il cuore", "Susanna Tamaro")
        );
    }
}
