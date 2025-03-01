package com.erp_autopartes.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hello {

    @GetMapping("/hello")
    String hello() {
        return "Holaaa";
    }
}
