package com.houston.streaming.dominio.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface StreamAiService {

    @UserMessage("Hola")
    String greetings();
}
