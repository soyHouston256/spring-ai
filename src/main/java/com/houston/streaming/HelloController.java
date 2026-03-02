package com.houston.streaming;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class HelloController {

    private final StreamAiService streamAiService;

    public HelloController(StreamAiService streamAiService) {
        this.streamAiService = streamAiService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(defaultValue = "Hello!") String message) {
        return streamAiService.chat(message);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream(@RequestParam(defaultValue = "Hello!") String message) {
        SseEmitter emitter = new SseEmitter();

        streamAiService.chatStream(message)
                .onPartialResponse(token -> {
                    try {
                        emitter.send(token);
                    } catch (Exception e) {
                        emitter.completeWithError(e);
                    }
                })
                .onCompleteResponse(response -> emitter.complete())
                .onError(emitter::completeWithError)
                .start();

        return emitter;
    }
}
