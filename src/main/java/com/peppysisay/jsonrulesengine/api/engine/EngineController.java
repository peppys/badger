package com.peppysisay.jsonrulesengine.api.engine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/engine/**")
public class EngineController {
    @GetMapping("/")
    public Map<String, String> evaluate() {
        return new HashMap<String, String>() {{
            put("rules", "none-yet");
        }};
    }
}
