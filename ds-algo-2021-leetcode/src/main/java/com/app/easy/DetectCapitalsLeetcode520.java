package com.app.easy;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class DetectCapitalsLeetcode520 {
    private static boolean detectCapitalUse(String word) {
        int upperCaseCount = 0;
        boolean hasZeroIndexCap = false;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                if(i == 0) {
                    hasZeroIndexCap = true;
                }
                upperCaseCount++;
            }
        }

        return (upperCaseCount == 0 || upperCaseCount == word.length() || (upperCaseCount == 1 && hasZeroIndexCap));
    }

    public static void main(String[] args) {

    }
}
