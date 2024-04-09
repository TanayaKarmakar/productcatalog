package com.app.easy;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharactersLeetcode1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int len = 0;
        for(String word: words) {
            Map<Character, Integer> origMap = new HashMap<>(map);
            if(canBeFormed(map, word)) {
                len += word.length();
            }
            map = new HashMap<>(origMap);
        }

        return len;
    }

    private boolean canBeFormed(Map<Character, Integer> map, String word) {

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!map.containsKey(ch))
                return false;
            int value = map.get(ch);
            value--;
            if(value == 0) {
                map.remove(ch);
            } else {
                map.put(ch, value);
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
