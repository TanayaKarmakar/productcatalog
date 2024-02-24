package com.app.medium;

import java.util.*;

public class GroupAnagramLeetcode49 {
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedWord = new String(array);
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(str);
        }

        List<List<String>> finalResult = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            finalResult.add(entry.getValue());
        }
        return finalResult;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> finalResult = groupAnagrams(strs);

        System.out.println(finalResult);
    }
}
