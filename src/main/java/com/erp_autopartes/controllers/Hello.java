package com.erp_autopartes.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("api/hello")
    String hello() {
        return "Holaaa";
    }
}
