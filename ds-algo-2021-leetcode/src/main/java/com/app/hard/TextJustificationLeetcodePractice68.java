package com.app.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationLeetcodePractice68 {
    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        int i = 0;
        while(i < words.length) {
            List<String> wordList = getWords(words, i, maxWidth);
            i += wordList.size();
            justifiedText.add(justifyText(words, wordList, i, maxWidth));
        }
        return justifiedText;
    }

    private static String justifyText(String[] words, List<String> wordList, int i, int maxWidth) {
        int totalLen = -1;
        for(String word: wordList) {
            totalLen += word.length();
        }

        int remainingSpaces = maxWidth - totalLen;
        int numSpaces = wordList.size() - 1;

        if(wordList.size() == 1 || i == words.length) {
            return String.join(" ", wordList) + " ".repeat(remainingSpaces);
        }

        int extraSpace = remainingSpaces % numSpaces;
        int mustHaveSpaces = remainingSpaces / numSpaces;


        for(int j = 0; j < extraSpace; j++) {
            wordList.set(j, wordList.get(j) + " ");
        }

        for(int j = 0; j < mustHaveSpaces; j++) {
            wordList.set(j, wordList.get(j) + " ".repeat(mustHaveSpaces));
        }
        return String.join(" ", wordList);
    }

    private static List<String> getWords(String[] words, int i, int maxWidth) {
        int currentLen = 0;
        List<String> wordList = new ArrayList<>();
        while(i < words.length && currentLen + words[i].length() <= maxWidth) {
            wordList.add(words[i]);
            currentLen += words[i].length() + 1;
            i++;
        }
        return wordList;
    }

    public static void main(String[] args) {

    }
}
