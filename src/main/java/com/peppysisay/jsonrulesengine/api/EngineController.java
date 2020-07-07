package com.peppysisay.jsonrulesengine.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EngineController {
    @GetMapping("/")
    public String evaluate(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }
}
