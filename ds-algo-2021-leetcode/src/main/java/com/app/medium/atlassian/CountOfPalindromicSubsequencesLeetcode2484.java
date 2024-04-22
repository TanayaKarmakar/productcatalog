package com.app.medium.atlassian;

import java.util.ArrayList;
import java.util.List;

public class CountOfPalindromicSubsequencesLeetcode2484 {
    private static int countPalindromes(String s) {
        int count = 0;
        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateCombinations(s, 0, sb, combinations);
        for(String current: combinations) {
            if(isPalindrome(current)) {
                count++;
            }
        }
        //System.out.println(combinations);
        return count;
    }

    private static boolean isPalindrome(String current) {
        int start = 0;
        int end = current.length() - 1;
        while(start <= end) {
            if(current.charAt(start) != current.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }


    private static void generateCombinations(String s, int indx, StringBuilder sb, List<String> combinations) {
        if(sb.length() == 5) {
            combinations.add(sb.toString());
            return;
        }
        if(indx >= s.length())
            return;

        for(int i = indx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            generateCombinations(s, i + 1, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(countPalindromes("103301"));
        System.out.println(countPalindromes("0000000"));
    }
}
