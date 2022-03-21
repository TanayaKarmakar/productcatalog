package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class NumberOfStepsToReduceItTooZeroLeetcode1342 {
    private static int numberOfSteps(int num) {
        if(num == 0)
            return 0;
        int[] dp = new int[num + 1];
        dp[1] = 1;

        for(int i = 2; i <= num; i++) {
            if((i % 2) == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[num];
    }

    public static void main(String[] args) {

    }
}
