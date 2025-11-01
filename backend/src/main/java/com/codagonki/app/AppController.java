package com.codagonki.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    
}
