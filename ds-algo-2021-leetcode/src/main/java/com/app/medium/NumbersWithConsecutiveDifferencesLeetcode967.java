package com.app.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class NumbersWithConsecutiveDifferencesLeetcode967 {
    private static int[] numsSameConsecDiff(int n, int k) {
        Queue<String> q = new LinkedList<>();

        for(int i = 1; i <= 9; i++) {
            q.add(i + "");
        }

        int i = 2;
        while(!q.isEmpty() && i <= n) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String remNode = q.poll();

                int lastItem = remNode.charAt(remNode.length() - 1) - '0';
                if((lastItem + k) >= 0 && (lastItem + k) <= 9) {
                    char ch = (char) ((lastItem + k) + '0');
                    q.add(remNode + ch);
                }
                if(k != 0) {
                    if((lastItem - k) >= 0 && (lastItem - k) <= 9) {
                        char ch = (char)((lastItem - k) + '0');
                        q.add(remNode + ch);
                    }
                }
            }
            i++;
        }

        int[] items = new int[q.size()];
        i = 0;
        while(!q.isEmpty()) {
            items[i++] = Integer.parseInt(q.poll());
        }
        return items;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 7;

        int[] res = numsSameConsecDiff(n, k);

        System.out.println(Arrays.toString(res));
    }
}
