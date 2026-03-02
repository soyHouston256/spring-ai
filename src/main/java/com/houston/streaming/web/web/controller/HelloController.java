package com.houston.streaming.web.web.controller;

import com.houston.streaming.dominio.service.StreamAiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final StreamAiService streamAiService;

    public HelloController(StreamAiService streamAiService) {
        this.streamAiService = streamAiService;
    }

    @GetMapping("/")
    public String hello() {
        return  this.streamAiService.greetings();
    }


}
