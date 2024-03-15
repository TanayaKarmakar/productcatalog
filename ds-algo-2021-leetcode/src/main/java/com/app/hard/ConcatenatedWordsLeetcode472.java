package com.app.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWordsLeetcode472 {
    private static List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words.length <= 1)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for(String word: words) {
            wordSet.add(word);
        }

        for(String word: words) {
            if(word.equals(""))
                continue;
            wordSet.remove(word);
            if(canBreak(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        return result;
    }

    private static boolean canBreak(String word, Set<String> wordSet) {
        int n = word.length();
        boolean[] canBreak = new boolean[n + 1];
        canBreak[0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(canBreak[j]) {
                    String str = word.substring(j, i);
                    if(wordSet.contains(str)) {
                        canBreak[i] = true;
                    }
                }
            }
        }
        return canBreak[n];
    }

    public static void main(String[] args) {

    }
}
