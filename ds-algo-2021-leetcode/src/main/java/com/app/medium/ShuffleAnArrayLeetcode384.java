package com.app.medium;

import java.util.Random;

public class ShuffleAnArrayLeetcode384 {
    class Solution {
        private int[] original;
        private int[] current;
        private Random random;

        public Solution(int[] nums) {
            this.original = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                this.original[i] = nums[i];
            }
            this.current = nums;
            this.random = new Random();
        }

        public int[] reset() {
            return this.original;
        }

        public int[] shuffle() {
            if(current.length == 0)
                return new int[]{};
            int min = 0;
            int max = current.length - 1;
            int randIndx = random.nextInt(max - min + 1);
            swap(current, randIndx, max);
            return current;
        }

        private void swap(int[] current, int i, int j) {
            int tmp = current[i];
            current[i] = current[j];
            current[j] = tmp;
        }
    }

    public static void main(String[] args) {

    }
}
