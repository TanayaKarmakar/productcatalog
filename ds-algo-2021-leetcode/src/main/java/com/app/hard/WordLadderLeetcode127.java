package com.app.hard;

import java.util.*;

public class WordLadderLeetcode127 {
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();

        List<String> newList = new ArrayList<>(wordList);
        List<String> wordsToBeDeleted = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);

        int count = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if(currentWord.equals(endWord))
                    return count;

                visited.add(currentWord);

                for(String word: newList) {
                    if(diff(word, currentWord) == 1 && !visited.contains(word)) {
                        queue.add(word);
                        wordsToBeDeleted.add(word);
                    }
                }
                newList.removeAll(wordsToBeDeleted);
            }
            count++;
        }
        return 0;
    }

    private static int diff(String word1, String word2) {
        if(word1.length() != word2.length())
            return Integer.MAX_VALUE;

        int n = word1.length();
        int diffCount = 0;

        int i = 0;
        while(i < n) {
            if(word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if(diffCount > 1)
                    return diffCount;
            }
            i++;
        }
        return diffCount;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");

        System.out.println(ladderLength("hit", "cog", words));
    }
}
