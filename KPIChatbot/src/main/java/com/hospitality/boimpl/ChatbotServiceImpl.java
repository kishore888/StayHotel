package com.hospitality.boimpl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
//import org.springframework.ai.vectorstore.SearchRequest.SimilaritySearchRequest;


import org.springframework.beans.factory.annotation.Autowired;

import com.hospitality.bo.ChatbotService;
import com.hospitality.utils.VectorDecoder;

public class ChatbotServiceImpl implements ChatbotService {
	
	@Autowired
    private ChatClient chatClient;
	
	private final VectorStore vectorStore;
	
    private final VectorDecoder decoder;
	
	public ChatbotServiceImpl(ChatClient chatClient, VectorStore vectorStore, VectorDecoder decoder) {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
        
        this.decoder = decoder;
    }

	@Override
	public void indexTexts(List<String> texts) {
		List<Document> documents = texts.stream()
	            .map(Document::new)
	            .toList();

	        vectorStore.add(documents);
	}
	
//	public List<String> search(float[] queryVector, int topK) {
//        List<VectorStore.SearchResult> results = vectorStore.similaritySearch(queryVector, topK);
//        return results.stream()
//                      .map(result -> decoder.decode(result.getEmbedding()))
//                      .collect(Collectors.toList());
//    }

//	public List<Document> search(String query, int topK) {
//        SimilaritySearchRequest request = SimilaritySearchRequest.builder()
//            .query(query)
//            .topK(topK)
//            .build();
//
//        return vectorStore.similaritySearch(request);
//    }
	
	public List<Document> search(String query, int topK) {
        SearchRequest request = SearchRequest.builder()
            .query(query)
            .topK(topK)
            .build();

        return vectorStore.similaritySearch(request);
    }
	
	@Override
	public String chat(String userMessage) {
//		String reply = chatClient.prompt().user(userMessage).call().content(); 
		String reply = "what";
		return reply;
	}

}
