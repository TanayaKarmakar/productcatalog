package com.app.medium;

import java.util.List;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    private static int maxLength(List<String> arr) {
        int total = (int)Math.pow(2, arr.size());
        int maxLen = 0;

        for(int i = 0; i < total; i++) {
            int temp = i;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    sb.append(arr.get(j));
                }
                j++;
                temp = temp >> 1;
            }

            boolean isUnique = true;
            int[] charFreq = new int[26];
            String str = sb.toString();
            for(int k = 0; k < str.length(); k++) {
                int indx = str.charAt(k) - 'a';
                if(charFreq[indx] > 0) {
                    isUnique =false;
                    break;
                }
                charFreq[indx]++;
            }
            if(isUnique) {
                maxLen = Integer.max(str.length(), maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
