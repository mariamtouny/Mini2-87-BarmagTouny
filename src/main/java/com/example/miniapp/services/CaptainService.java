package com.example.miniapp.services;

import com.example.miniapp.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptainService {
    private final CaptainRepository captainRepository;

    @Autowired
    public CaptainService(CaptainRepository captainRepository){
        this.captainRepository = captainRepository;
    }
}
