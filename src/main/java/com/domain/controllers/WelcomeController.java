package com.domain.controllers;

import org.springframework.web.bind.annotation.GetMapping; // GET METHOD
import org.springframework.web.bind.annotation.PostMapping; // POST METHOD
import org.springframework.web.bind.annotation.RequestMapping; // for URL MAPPING / ENDPOINT
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to SpringBoot REST API";
    }

    @PostMapping
    public String other(){
        return "Data lain";
    }

}
