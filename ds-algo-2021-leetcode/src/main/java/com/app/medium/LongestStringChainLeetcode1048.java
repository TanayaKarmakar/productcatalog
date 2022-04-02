package com.app.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
class ValueComparator5 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() == o2.length())
            return o1.compareTo(o2);
        return o1.length() - o2.length();
    }
}

public class LongestStringChainLeetcode1048 {
    private static int longestStrChain(String[] words) {
        Arrays.sort(words, new ValueComparator5());

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);


        int maxVal = 1;
        for(int i = n - 1; i > 0 ; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(words[j].length() == words[i].length())
                    continue;
                if(words[i].length() > words[j].length() + 1)
                    break;
                if(isPredecessor(words[i], words[j])) {
                    dp[j] = Integer.max(dp[j], dp[i] + 1);
                    maxVal = Integer.max(maxVal, dp[j]);
                }
            }
        }
        return maxVal;
    }

    private static boolean isPredecessor(String word, String word1) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < word.length() && j < word1.length()) {
            if(word.charAt(i) != word1.charAt(j)) {
                count++;
                if(count > 1)
                    return false;
            } else {
                j++;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
