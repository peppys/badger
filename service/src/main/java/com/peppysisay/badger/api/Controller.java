package com.peppysisay.badger.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.peppys.badger.Badge;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/badge.svg")
    public ResponseEntity<String> render(@RequestParam String label_text,
                                         @RequestParam String label_color,
                                         @RequestParam String message_text,
                                         @RequestParam String message_color) throws Exception {
        Badge badge = Badge.builder()
                .setLabelText(label_text)
                .setLabelColor(label_color)
                .setMessageText(message_text)
                .setMessageColor(message_color)
                .build();

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.set("Content-Type", "image/svg+xml");

        return new ResponseEntity<>(badge.render(), responseHeaders, HttpStatus.OK);
    }
}
