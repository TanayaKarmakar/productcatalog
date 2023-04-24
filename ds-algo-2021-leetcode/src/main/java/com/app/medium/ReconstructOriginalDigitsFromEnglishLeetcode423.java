package com.app.medium;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */
public class ReconstructOriginalDigitsFromEnglishLeetcode423 {
  private static String originalDigits(String s) {
    String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int[] freqMap = new int[26];

    for(int i = 0; i < s.length(); i++) {
      freqMap[s.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < digits.length; ) {
      boolean digitFound = true;
      String currentDigit = digits[i];
      for(int j = 0; j < currentDigit.length(); j++) {
        if(freqMap[currentDigit.charAt(j) - 'a'] == 0) {
          digitFound = false;
          break;
        }
      }

      if(digitFound) {
        sb.append(i);
        for(int j = 0; j < currentDigit.length(); j++) {
          freqMap[currentDigit.charAt(j) - 'a']--;
        }
      } else {
        i++;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(originalDigits("zerozero"));
    System.out.println(originalDigits("owoztneoerone"));
    System.out.println(originalDigits("fviefuro"));
  }
}
