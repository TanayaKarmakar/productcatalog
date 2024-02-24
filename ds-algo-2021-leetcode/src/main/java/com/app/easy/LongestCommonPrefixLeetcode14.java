package com.app.easy;

public class LongestCommonPrefixLeetcode14 {
    private static String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for(int i = 1; i < strs.length; i++) {
            String currentStr = strs[i];
            int i1 = 0;
            int j1 = 0;
            int count = 0;
            while(i1 < result.length() && j1 < currentStr.length()
            && result.charAt(i1) == currentStr.charAt(j1)) {
                i1++;
                j1++;
                count++;
            }
            result = result.substring(0, count);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        String result = longestCommonPrefix(strs);

        System.out.println(result);
    }
}
