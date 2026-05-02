package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.bo.ChatbotService;

@RestController
@RequestMapping("/kpi/chatbot/")
public class ChatbotController {
	
	@Autowired
	private ChatbotService chatbotService;

    @PostMapping(value="/chat")
    public ResponseEntity<String> chat(@RequestBody String userMessage) {
    	chatbotService.chat(userMessage);
		String reply = "what";
		
		List<String> texts = List.of("This is good","but not bad");
		chatbotService.indexTexts(texts);
        return ResponseEntity.ok(reply);
    }
    
}
