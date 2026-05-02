package com.hospitality.bo;

import java.util.List;

public interface ChatbotService {

	void indexTexts(List<String> texts);

	String chat(String userMessage);

}
