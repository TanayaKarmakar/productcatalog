package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 23/04/22
 * @project ds-algo-2021
 */
public class LongestSubstringAtLeastKRepeatingCharactersLeetcode395 {
    private static int longestSubstring(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = n - 1;
        int left = 0;
        int right = n - 1;

        while(i <= j) {
            if(freq[s.charAt(i) - 'a'] < k) {
                while(left <= i) {
                    freq[s.charAt(left) - 'a']--;
                    left++;
                }
                j = right;
                i++;
            } else if(freq[s.charAt(j) - 'a'] < k) {
                while(right >= j) {
                    freq[s.charAt(right) - 'a']--;
                    right--;
                }
                i = left;
                j--;
            } else {
                i++;
                j--;
            }
        }

        return (right - left + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        int ans = longestSubstring(str, k);

        System.out.println(ans);

        scanner.close();
    }
}
