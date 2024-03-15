package com.app.medium;

import java.util.Arrays;

public class PermutationInStringLeetcode567 {
    private static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int left = 0;
        int right = 0;
        int n = s2.length();
        int windowSize = s1.length();
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(right = 0; right < windowSize; right++) {
            s1Freq[s1.charAt(right) - 'a']++;
            s2Freq[s2.charAt(right) - 'a']++;
        }

        if(Arrays.equals(s1Freq, s2Freq))
            return true;

        while(right < n) {
            s2Freq[s2.charAt(left) - 'a']--;
            s2Freq[s2.charAt(right) - 'a']++;
            if(Arrays.equals(s1Freq, s2Freq))
                return true;
            left++;
            right++;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
