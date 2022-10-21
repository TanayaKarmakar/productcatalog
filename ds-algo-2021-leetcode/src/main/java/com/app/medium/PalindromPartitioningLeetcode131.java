package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 26/09/22
 * @project ds-algo-2021-leetcode
 */
public class PalindromPartitioningLeetcode131 {
    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        partitionRec(s, current, result, 0);
        return result;
    }

    private static void partitionRec(String s, List<String> current, List<List<String>> result, int indx) {
        if(indx == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = indx; i < s.length(); i++) {
            if(isPalindrome(s, indx, i)) {
                current.add(s.substring(indx, i + 1));
                partitionRec(s, current, result, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> res = partition(str);

        System.out.println(res);
    }
}
