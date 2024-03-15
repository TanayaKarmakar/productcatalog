package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInStringLeetcode438 {
    private static List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())
            return findAnagrams(p, s);
        int n = s.length();
        int windowSize = p.length();

        int[] sIndx = new int[26];
        int[] pIndx = new int[26];
        List<Integer> result = new ArrayList<>();
        int right = 0;
        int left = 0;
        for(right = 0; right < windowSize; right++) {
            sIndx[s.charAt(right) - 'a']++;
            pIndx[p.charAt(right) - 'a']++;
        }

        while(right < n) {
            if(Arrays.equals(sIndx, pIndx)) {
                result.add(left);
            }
            sIndx[s.charAt(left) - 'a']--;
            sIndx[s.charAt(right) - 'a']++;
            left++;
            right++;
        }

        if(Arrays.equals(sIndx, pIndx)) {
            result.add(left);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
