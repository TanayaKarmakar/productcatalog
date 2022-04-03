package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class FindAnagramsLeetcode438 {
    private static List<Integer> findAnagrams(String s, String p) {
        int windowSize = p.length();
        List<Integer> list = new ArrayList<>();

        int n = s.length();
        int i = 0;
        while(i + windowSize < n) {
            String ss = s.substring(i, i + windowSize);
            if(isAnagram(ss, p))
                list.add(i);
            i++;
        }
        return list;
    }

    private static boolean isAnagram(String ss, String p) {
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for(int i = 0; i < ss.length(); i++) {
            sFreq[ss.charAt(i) - 'a']++;
            pFreq[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(sFreq[i] != pFreq[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "cbaebabacd";
        String p = "abc";

        List<Integer> list = findAnagrams(str, p);
        System.out.println(list);
    }
}
