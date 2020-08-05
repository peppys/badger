package com.peppysisay.badger.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/")
    public Map<String, String> evaluate() {
        return new HashMap<String, String>() {{
            put("service", "badger");
        }};
    }
}
