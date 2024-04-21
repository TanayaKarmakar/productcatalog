package com.app.medium.salesforce;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequencesLeetcode792 {
    private static int numMatchingSubseq(String s, String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(isSubsequence(s, entry.getKey())) {
                count += entry.getValue();
            }
        }
        return count;
    }

    private static boolean isSubsequence(String mainWord, String token) {
        int m = mainWord.length();
        int n = token.length();
        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            if(mainWord.charAt(i) == token.charAt(j)) {
                j++;
            }
            i++;
            if(j == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
