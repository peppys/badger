package com.peppysisay.badger.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.peppys.badger.Badge;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/badge.svg")
    public String render(@RequestParam String label_text,
                         @RequestParam String label_color,
                         @RequestParam String message_text,
                         @RequestParam String message_color,
                         HttpServletResponse response) throws Exception {
        Badge badge = Badge.builder()
                .setLabelText(label_text)
                .setLabelColor(label_color)
                .setMessageText(message_text)
                .setMessageColor(message_color)
                .build();

        response.setHeader("Content-Type", "image/svg+xml");

        return badge.render();
    }
}
