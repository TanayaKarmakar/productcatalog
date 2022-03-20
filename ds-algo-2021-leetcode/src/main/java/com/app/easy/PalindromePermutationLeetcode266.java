package com.app.easy;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class PalindromePermutationLeetcode266 {
    private static boolean canPermutePalindrome(String s) {
        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        int oddCharsCount = 0;
        int evenCharsCount = 0;
        for(int i = 0; i < 26; i++) {
            if(chars[i] > 0) {
                if(chars[i] % 2 == 0) {
                    evenCharsCount++;
                } else {
                    oddCharsCount++;
                }
            }
        }
        return oddCharsCount <= 1;
    }

    public static void main(String[] args) {
        String str = "aaa";

        System.out.println(canPermutePalindrome(str));
    }
}
