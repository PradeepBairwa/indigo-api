package com.indigo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*")
public class WebSocketController {

    @MessageMapping("/flight-status")
    @SendTo("/topic/flight-status")
    public String send(String message) {
        return message;
    }
}

