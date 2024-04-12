package com.app.medium;

import java.util.*;

public class SentenceSimilarityIILeetcode737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length)
            return false;
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> currentpair: similarPairs) {
           String p1 = currentpair.get(0);
           String p2 = currentpair.get(1);

           if(!map.containsKey(p1))
               map.put(p1, new ArrayList<>());
           map.get(p1).add(p2);

           if(!map.containsKey(p2))
               map.put(p2, new ArrayList<>());
           map.get(p2).add(p1);
        }


        int n = sentence1.length;
        for(int i = 0; i < n; i++) {
            String token1 = sentence1[i];
            String token2 = sentence2[i];
            Set<String> visited = new HashSet<>();

            if(!isSimilar(token1, token2, map, visited))
                return false;
        }

        return true;
    }

    private boolean isSimilar(String token1, String token2, Map<String, List<String>> map, Set<String> visited) {
        if(token1.equals(token2))
            return true;
        List<String> neighbors = map.getOrDefault(token1, new ArrayList<>());
        visited.add(token1);

        for(String nei: neighbors) {
            if(!visited.contains(nei)) {
                if(isSimilar(nei, token2, map, visited))
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
