package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class ReplaceAllQuestionMarkLeetcode1576 {
    private static String modifyString(String s) {
        char[] charArr = new char[26];
        for(int i = 0; i < 26; i++) {
            charArr[i] = (char)(97 + i);
        }

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char min = Character.MIN_VALUE;
            char max = Character.MIN_VALUE;
            if(arr[i] == '?') {
                if(i - 1 >= 0)
                    min = arr[i - 1];
                if(i + 1 < arr.length)
                    max = arr[i + 1];
                char finalChar = find(charArr, min, max);
                arr[i] = finalChar;
            }
        }
        return new String(arr);
    }

    private static char find(char[] charArr, char min, char max) {
        for(int i = 0; i < 26; i++) {
            if(charArr[i] != min && charArr[i] != max)
                return charArr[i];
        }
        return Character.MIN_VALUE;
    }


    public static void main(String[] args) {

    }
}
