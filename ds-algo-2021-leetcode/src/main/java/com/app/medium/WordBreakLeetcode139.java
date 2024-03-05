package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreakLeetcode139 {
    private static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                String currentWord = s.substring(j, i + 1);
                if(wordDict.contains(currentWord)) {
                    if(j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i] += 1;
                    }
                }
            }
        }

        return dp[s.length() - 1] > 0;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));

        wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak("applepenapple", wordDict));

        wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak("catsandog", wordDict));
    }
}
