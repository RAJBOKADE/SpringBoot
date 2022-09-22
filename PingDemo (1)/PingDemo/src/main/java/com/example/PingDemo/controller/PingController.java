package com.example.PingDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PingController {

    @GetMapping ("/pings")
    public ResponseEntity<Void> getPing() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
