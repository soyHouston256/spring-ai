package com.houston.streaming;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.TokenStream;

@AiService
public interface StreamAiService {

    @SystemMessage("You are a helpful assistant.")
    String chat(@UserMessage String userMessage);

    @SystemMessage("You are a helpful assistant.")
    TokenStream chatStream(@UserMessage String userMessage);
}
