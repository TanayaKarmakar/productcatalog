package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
public class PalindromicPartitionLeetcode131 {
    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        partitionRec(s, 0, curr, res);

        return res;
    }

    private static void partitionRec(String s, int indx, List<String> curr, List<List<String>> res) {
        if(indx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = indx; i < s.length(); i++) {
            if(isPalindrome(s, indx, i)) {
                curr.add(s.substring(indx, i + 1));
                partitionRec(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
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
        String str = "aabb";
        List<List<String>> result = partition(str);

        System.out.println(result);
    }
}
