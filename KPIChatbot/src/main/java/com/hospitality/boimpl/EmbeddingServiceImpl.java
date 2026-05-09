package com.hospitality.boimpl;

import org.springframework.stereotype.Service;

import com.hospitality.bo.EmbeddingService;

@Service
public class EmbeddingServiceImpl implements EmbeddingService {

    // private final HuggingFaceEmbeddingClient embeddingClient;
    // private final FaissIndex index;

    // public EmbeddingService() {
    //     this.embeddingClient = new HuggingFaceEmbeddingClient(
    //         HuggingFaceEmbeddingOptions.builder()
    //             .withModel("sentence-transformers/all-MiniLM-L6-v2")
    //             .withNormalize(true)
    //             .withDevice("cpu")
    //             .build()
    //     );

    //     this.index = new FaissIndex(384); // 384 dims for MiniLM
    // }

    // public void storeText(String text) {
    //     List<String> chunks = chunkText(text, 100);
    //     for (String chunk : chunks) {
    //         List<Double> embedding = embeddingClient.embed(chunk);
    //         index.add(UUID.randomUUID().toString(), chunk, toFloatArray(embedding));
    //     }
    // }

    // public String search(String query) {
    //     List<Double> queryEmbedding = embeddingClient.embed(query);
    //     FaissIndex.SearchResult result = index.search(toFloatArray(queryEmbedding), 1).get(0);
    //     return result.getValue();
    // }

    // private List<String> chunkText(String text, int chunkSize) {
    //     List<String> chunks = new ArrayList<>();
    //     String[] words = text.split("\\s+");
    //     for (int i = 0; i < words.length; i += chunkSize) {
    //         chunks.add(String.join(" ", Arrays.copyOfRange(words, i, Math.min(i + chunkSize, words.length))));
    //     }
    //     return chunks;
    // }

    // private float[] toFloatArray(List<Double> list) {
    //     float[] array = new float[list.size()];
    //     for (int i = 0; i < list.size(); i++) array[i] = list.get(i).floatValue();
    //     return array;
    // }
}

