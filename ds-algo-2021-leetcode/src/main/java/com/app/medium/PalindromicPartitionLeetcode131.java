package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitionLeetcode131 {
    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentResult = new ArrayList<>();
        partitionRec(s, 0, currentResult, result);
        return result;
    }

    private static void partitionRec(String s, int indx, List<String> currentResult, List<List<String>> result) {
        if(indx == s.length()) {
            result.add(new ArrayList<>(currentResult));
            return;
        }
        for(int i = indx; i < s.length(); i++) {
            if(isPalindrome(s, indx, i)) {
                currentResult.add(s.substring(indx, i + 1));
                partitionRec(s, i + 1, currentResult, result);
                currentResult.remove(currentResult.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<String>> result = partition("aab");

        System.out.println(result);
    }
}
