package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class ReverseVowelsInStringLeetcode345 {
    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }

    private static String reverseVowels(String s) {
        char[] sArr = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if(isVowel(sArr[start]) && isVowel(sArr[end])) {
                char tmp = sArr[start];
                sArr[start] = sArr[end];
                sArr[end] = tmp;
                start++;
                end--;
            }
            if(!isVowel(sArr[start])) {
                start++;
            }
            if(!isVowel(sArr[end])) {
                end--;
            }
        }
        return new String(sArr);
    }

    public static void main(String[] args) {
        String str = "hello";

        System.out.println(reverseVowels(str));

        str = "leetcode";

        System.out.println(reverseVowels(str));
    }
}
