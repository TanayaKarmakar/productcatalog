package com.app.easy;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class IsomorphicStringsLeetcode205 {
    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sCharCount = new int[256];
        int[] tCharCount = new int[256];
        int[] sIndx = new int[256];
        int[] tIndx = new int[256];

        for(int i = 0; i < s.length(); i++) {
            sCharCount[s.charAt(i)]++;
            tCharCount[t.charAt(i)]++;
            sIndx[s.charAt(i)] = i;
            tIndx[t.charAt(i)] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            if((sCharCount[s.charAt(i)] != tCharCount[t.charAt(i)])
                || (sIndx[s.charAt(i)] != tIndx[t.charAt(i)]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
