package com.app.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class WordBreakLeetcode139 {
    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordDict) {
            wordSet.add(word);
        }
        int n = s.length();
        boolean[] isBreak = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(!isBreak[j])
                    continue;
                String str = s.substring(j, i);
                if(wordSet.contains(str)) {
                    isBreak[i] = true;
                    break;
                }
            }
        }

        return isBreak[n];
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(str, wordDict));


    }
}
