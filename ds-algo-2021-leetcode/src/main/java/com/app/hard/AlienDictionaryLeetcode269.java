package com.app.hard;

import java.util.*;

public class AlienDictionaryLeetcode269 {
    private static String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegMap = new HashMap<>();

        for(String word: words) {
            for(char ch: word.toCharArray()) {
                inDegMap.put(ch, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Integer.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.startsWith(w2))
                return "";

            for(int j = 0; j < len; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if(ch1 != ch2) {
                    if(!map.containsKey(ch1))
                        map.put(ch1, new ArrayList<>());
                    map.get(ch1).add(ch2);
                    inDegMap.put(ch2, inDegMap.get(ch2) + 1);
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: inDegMap.entrySet()) {
            if(entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        while(!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);

            List<Character> neighbors = map.getOrDefault(ch, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Character ch1: neighbors) {
                    int deg = inDegMap.get(ch1);
                    deg--;
                    if(deg == 0) {
                        queue.add(ch1);
                    }
                    inDegMap.put(ch1, deg);
                }
            }
        }

        return inDegMap.size() == sb.length() ? sb.toString(): "";
    }

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        String ans = alienOrder(words);

        System.out.println(ans);
    }
}
