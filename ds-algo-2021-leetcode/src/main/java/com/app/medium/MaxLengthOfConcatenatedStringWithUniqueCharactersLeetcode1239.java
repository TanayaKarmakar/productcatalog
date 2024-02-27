package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthOfConcatenatedStringWithUniqueCharactersLeetcode1239 {
    private static int maxLength(List<String> arr) {
        int totalCombinations = (int)Math.pow(2, arr.size());

        int maxLen = 0;
        for(int i = 0; i < totalCombinations; i++) {
            int current = i;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(current != 0) {
                if((current & 1) == 1) {
                    sb.append(arr.get(j));
                }
                j++;
                current = current >> 1;
            }


            String str = sb.toString();
            int[] freq = new int[26];
            boolean notUnique = false;
            for(int k = 0; k < str.length(); k++) {
                int charIndx = str.charAt(k) - 'a';
                if(freq[charIndx] == 1) {
                    notUnique = true;
                    break;
                }
                freq[charIndx]++;
            }

            if(!notUnique) {
                maxLen = Integer.max(maxLen, str.length());
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("un");
        list.add("iq");
        list.add("ue");

        System.out.println(maxLength(list));
    }
}
