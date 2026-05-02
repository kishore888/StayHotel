package com.hospitality;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sampletest {

	public static void main(String[] args) throws Exception {
        List<String> list1 = List.of("[{'internal1':{'value':'true','desc':'All'},'internal2':{'value':'true','desc':'All'}}]");
        List<String> list2 = List.of("[{'internal1':{'value':'false','desc':'All'},'internal2':{'value':'true','desc':'None'}}]");

        ObjectMapper mapper = new ObjectMapper();

        // Sanitize single quotes
        List<String> sanitizedList1 = list1.stream().map(s -> s.replace("'", "\"")).toList();
        List<String> sanitizedList2 = list2.stream().map(s -> s.replace("'", "\"")).toList();

        boolean matchFound = sanitizedList1.stream()
            .map(json -> parseJson(json, mapper))
            .anyMatch(listMap1 ->
                sanitizedList2.stream()
                    .map(json -> parseJson(json, mapper))
                    .anyMatch(listMap2 -> hasMatchingNestedEntry(listMap1, listMap2))
            );

        System.out.println("Match found: " + matchFound);
    }

    private static List<Map<String, Map<String, String>>> parseJson(String json, ObjectMapper mapper) {
        try {
            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Invalid JSON: " + json, e);
        }
    }

    private static boolean hasMatchingNestedEntry(List<Map<String, Map<String, String>>> list1,
                                                  List<Map<String, Map<String, String>>> list2) {
        return list1.stream().anyMatch(map1 ->
            list2.stream().anyMatch(map2 ->
                map1.entrySet().stream().anyMatch(entry1 -> {
                    String key = entry1.getKey();
                    Map<String, String> innerMap1 = entry1.getValue();
                    Map<String, String> innerMap2 = map2.get(key);

                    return innerMap2 != null && innerMap1.entrySet().stream()
                        .anyMatch(e -> Objects.equals(e.getValue(), innerMap2.get(e.getKey())));
                })
            )
        );
    }
}
