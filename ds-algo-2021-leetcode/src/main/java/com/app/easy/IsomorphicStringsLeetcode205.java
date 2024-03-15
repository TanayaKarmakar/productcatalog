package com.app.easy;

public class IsomorphicStringsLeetcode205 {
    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];
        int[] sIndx = new int[256];
        int[] tIndx = new int[256];

        for(int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i)]++;
            tFreq[t.charAt(i)]++;
            sIndx[s.charAt(i)] = i;
            tIndx[t.charAt(i)] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            int si = s.charAt(i);
            int ti = t.charAt(i);
            if(sFreq[si] != tFreq[ti] || sIndx[si] != tIndx[ti])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "mitle"));
    }
}
