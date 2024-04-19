package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IteratorForCombinationLeetcode1286 {
    static class CombinationIterator {
        private List<String> list;

        public CombinationIterator(String characters, int combinationLength) {
            list = new ArrayList<>();
            populateList(characters, combinationLength);
            Collections.sort(list);
        }

        public String next() {
            if(list.isEmpty())
                throw new RuntimeException("Item doesn't exist");
            return list.remove(0);
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }

        private void populateList(String characters, int combinationLength) {
            int len = characters.length();
            int totalCombinations = (int)Math.pow(2, len);

            for(int i = 0; i < totalCombinations; i++) {
                int temp = i;
                StringBuilder sb = new StringBuilder();
                int j = 0;
                while(temp != 0) {
                    if((temp & 1) == 1) {
                        sb.append(characters.charAt(j));
                    }
                    j++;
                    temp = (temp >> 1);
                }

                if(sb.length() == combinationLength) {
                    list.add(sb.toString());
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
