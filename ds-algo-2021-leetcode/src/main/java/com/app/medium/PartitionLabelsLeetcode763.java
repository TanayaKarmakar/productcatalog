package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 23/04/22
 * @project ds-algo-2021
 */
public class PartitionLabelsLeetcode763 {
    private static List<Integer> partitionLabels(String s) {
        int[] lastIndx = new int[26];
        int n = s.length();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIndx[ch - 'a'] = i + 1;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int finish = 1;

        while(finish <= n) {
            for(int i = start; i < finish; i++) {
                char ch = s.charAt(i);
                finish = Integer.max(finish, lastIndx[ch - 'a']);
            }
            result.add((finish - start));
            start = finish;
            finish++;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels(str);

        System.out.println(res);
    }
}
