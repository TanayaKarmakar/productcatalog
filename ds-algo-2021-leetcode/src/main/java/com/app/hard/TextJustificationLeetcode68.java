package com.app.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationLeetcode68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedResult = new ArrayList<>();
        for(int i = 0; i < words.length; ) {
            List<String> wordsList = getWords(words, i, maxWidth);
            // pointer moves to the location from where next line will be started
            i += wordsList.size();

            // text justification logic per line
            justifiedResult.add(justifiedText(wordsList, words, i, maxWidth));
        }

        return justifiedResult;
    }

    private static String justifiedText(List<String> wordList, String[] words, int indx, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        // calculate the total length of a particular, initialized with -1 so that we don't count the last word
        int totalLength = -1;
        for(String word: wordList) {
            totalLength += word.length() + 1;
        }


        // calculate remaining spaces
        int remainingSpace = maxWidth - totalLength;

        // if there is only one word or its the last word of last line then add all the spaces at the end of the word and return
        if(wordList.size() == 1 || indx == words.length) {
            return String.join(" ", wordList) + " ".repeat(remainingSpace);
        }

        // count number of spaces per line which is wordSizePerLine - 1
        int wordCount = wordList.size() - 1;

        // space that must be added after each word except last
        int mustNeedSpace = remainingSpace / wordCount;

        // extra spaces that needs to be distributed
        int extraSpace = remainingSpace % wordCount;

        for(int i = 0; i < extraSpace; i++) {
            wordList.set(i, wordList.get(i) + " ");
        }

        for(int i = 0; i < wordCount; i++) {
            wordList.set(i, wordList.get(i) + " ".repeat(mustNeedSpace));
        }

        return String.join(" ", wordList);
    }


    // This method will fetch the number of words that will fit per line by not exceeding the maxwidth
    private static List<String> getWords(String[] words, int i, int maxWidth) {
        List<String> wordsList = new ArrayList<>();
        int currentWordLen = 0;
        while(i < words.length && currentWordLen + words[i].length() <= maxWidth) {
            wordsList.add(words[i]);
            currentWordLen += words[i].length() + 1;
            i++;
        }
        return wordsList;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> ans = fullJustify(words, maxWidth);

        System.out.println(ans);
    }
}
