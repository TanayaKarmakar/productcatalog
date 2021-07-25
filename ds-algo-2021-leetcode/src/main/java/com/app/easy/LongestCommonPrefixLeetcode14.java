package com.app.easy;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */

public class LongestCommonPrefixLeetcode14 {
    private static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String prefix = strs[0];
        for(String str: strs) {
            while(!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String ans = longestCommonPrefix(strs);

        System.out.println(ans);
    }
}
