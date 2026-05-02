package com.hospitality.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaissIndex {

    private final IndexFlatL2 index;
    private final Map<Integer, String> idToText = new HashMap<>();
    private int currentId = 0;

//    public FaissIndex(int dimension) {
//        this.index = new IndexFlatL2(dimension);
//    }

    public void add(String id, String text, float[] vector) {
        index.add(new float[][]{vector});
        idToText.put(currentId++, text);
    }

    public List<SearchResult> search(float[] queryVector, int k) {
        int[] ids = new int[k];
        float[] distances = new float[k];
        index.search(queryVector, k, ids, distances);

        List<SearchResult> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            results.add(new SearchResult(ids[i], idToText.get(ids[i]), distances[i]));
        }
        return results;
    }

    public static class SearchResult {
        private final int id;
        private final String value;
        private final float score;

        public SearchResult(int id, String value, float score) {
            this.id = id;
            this.value = value;
            this.score = score;
        }

        public String getValue() {
            return value;
        }

        public float getScore() {
            return score;
        }
    }
}
