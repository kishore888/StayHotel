package com.hospitality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text")
public class TextController {

//	@Autowired
//    private EmbeddingService embeddingService;
//
//    public TextController(EmbeddingService embeddingService) {
//        this.embeddingService = embeddingService;
//    }
//
//    @PostMapping("/store")
//    public ResponseEntity<String> store(@RequestBody String text) {
//        embeddingService.storeText(text);
//        return ResponseEntity.ok("Text stored successfully.");
//    }
//
//    @PostMapping("/query")
//    public ResponseEntity<String> query(@RequestBody String query) {
//        String result = embeddingService.search(query);
//        return ResponseEntity.ok("Closest match: " + result);
//    }
}

