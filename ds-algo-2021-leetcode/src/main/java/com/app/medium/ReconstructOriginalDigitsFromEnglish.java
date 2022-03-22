package com.app.medium;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class ReconstructOriginalDigitsFromEnglish {
    private static String originalDigits(String s) {
        int[] charArr = new int[256];
        for(int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i)]++;
        }

        String[] digitWord = new String[]{"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < digitWord.length; i++) {
            String currDigit = digitWord[i];
            boolean allPresent = true;
            for(int j = 0; j < currDigit.length(); j++) {
                if(charArr[currDigit.charAt(j)] == 0) {
                    allPresent = false;
                    break;
                }
            }

            if(allPresent) {
                for(int j = 0; j < currDigit.length(); j++) {
                    charArr[currDigit.charAt(j)]--;
                }
                sb.append(i + "");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "owoztneoer";

        System.out.println(originalDigits(str));
    }
}
