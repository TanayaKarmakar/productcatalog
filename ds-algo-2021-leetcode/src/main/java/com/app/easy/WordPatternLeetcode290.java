package com.app.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPatternLeetcode290 {
    private static boolean wordPattern(String pattern, String s) {
        String[] tokens = s.split("\\s+");
        if(tokens.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> revMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if((map.containsKey(ch) && !map.get(ch).equals(tokens[i]))
                || (revMap.containsKey(tokens[i]) && revMap.get(tokens[i]) != ch ))
            {
                return false;
            }
            map.put(ch, tokens[i]);
            revMap.put(tokens[i], ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
