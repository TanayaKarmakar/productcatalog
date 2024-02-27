package com.app.easy;

public class FirstUniqueCharacterInAStringLeetcode387 {
    private static int firstUniqChar(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int charIndx = s.charAt(i) - 'a';
            freq[charIndx]++;
        }

        for(int i = 0; i < s.length(); i++) {
            int charIndx = s.charAt(i) - 'a';
            if(freq[charIndx] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
