package com.app.hard;

/**
 * @author t0k02w6 on 04/09/22
 * @project ds-algo-2021-leetcode
 */
public class LargestVarianceInASubstringLeetcode2272 {
    private static int largestVariance(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int ans = 0;
        for(int charA = 0; charA < 26; charA++) {
            for(int charB = 0; charB < 26; charB++) {
                if(charA != charB) {
                    ans = Integer.max(ans, calculateVarianceForPair((char)(charA + 'a'), (char)(charB + 'a'), s));
                }
            }
        }
        return ans;
    }

    private static int calculateVarianceForPair(char a, char b, String s) {
        int countA = 0;
        int countB = 0;
        boolean canExtendPrevB = false;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != a && ch != b)
                continue;
            if(ch == a)
                countA++;
            if(ch == b)
                countB++;
            if(countB > 0) {
                ans = Integer.max(ans, countA - countB);
            } else if(countB == 0 && canExtendPrevB) {
                ans = Integer.max(ans, countA - 1);
            }
            if(countA < countB) {
                countA = 0;
                countB = 0;
                canExtendPrevB = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aababbb";
        int ans = largestVariance(str);

        System.out.println(ans);
    }
}
