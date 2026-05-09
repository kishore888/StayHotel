package com.hospitality.boimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospitality.bo.ChatbotService;

// TODO: Re-add spring-ai-client-chat and spring-ai-vector-store dependencies
// and restore Spring AI implementation when Spring AI migration is complete.
@Service
public class ChatbotServiceImpl implements ChatbotService {

	@Override
	public void indexTexts(List<String> texts) {
		// TODO: implement with spring-ai-vector-store
	}

	@Override
	public String chat(String userMessage) {
		return "KPI Chatbot is under maintenance.";
	}

}
