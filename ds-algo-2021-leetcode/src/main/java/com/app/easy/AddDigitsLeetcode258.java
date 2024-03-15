package com.app.easy;

public class AddDigitsLeetcode258 {
    private static int addDigits(int num) {

        while(num > 9) {
            int temp = num;
            int sum = 0;
            while(temp != 0) {
                int r = temp % 10;
                sum = sum + r;
                temp = temp / 10;
            }
            num = sum;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
