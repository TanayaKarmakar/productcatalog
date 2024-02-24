package com.app.easy;

public class ValidPalindromeIILeetcode680 {
    private static boolean validPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = (n - 1);

        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }
        return isPossible(s, start) || isPossible(s, end);
    }

    private static boolean isPossible(String s, int indx) {
        String left = s.substring(0, indx);
        String right = s.substring(indx + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(left);
        sb.append(right);
        return sb.reverse().toString().equals(left + right);
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
    }
}
