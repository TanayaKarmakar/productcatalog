package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbersLeetcode1352 {
    static class ProductOfNumbers {
        private List<Integer> numbers;

        public ProductOfNumbers() {
            numbers = new ArrayList<>();
        }

        public void add(int num) {
            if(numbers.isEmpty()) {
                numbers.add(num);
            } else if(num == 0) {
                numbers = new ArrayList<>();
            } else {
                int prev = numbers.get(numbers.size() - 1);
                numbers.add(prev * num);
            }
        }

        public int getProduct(int k) {
            if(k > numbers.size())
                return 0;
            int n = numbers.size();
            if(n == k)
                return numbers.get(n - 1);
            return numbers.get(n - 1) / numbers.get(n - k - 1);
        }
    }

    public static void main(String[] args) {

    }
}
