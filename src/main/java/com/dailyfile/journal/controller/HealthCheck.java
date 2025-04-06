package com.dailyfile.journal.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheck {
    int value = -1;
    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }
    @GetMapping("/mental-health")
    public  String mentalHealth() { return "-99999999999";}

    @PostMapping("/post-health")
    public boolean postHealth(@RequestBody Integer newInt) {
        value = newInt;
        return true;
    }
    @GetMapping("get-health")
    public int getHealth() {
        return value;
    }
}
