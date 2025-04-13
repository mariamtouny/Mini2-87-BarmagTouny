package com.example.miniapp.controllers;

import com.example.miniapp.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/captain")
public class CaptainController {

    private final CaptainService captainService;
    @Autowired
    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }

}
