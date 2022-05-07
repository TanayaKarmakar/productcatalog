package com.app.medium;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class BestSightSeeingPairLeetcode1014 {
    private static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int maxAi = values[0] + 0;

        int ans = -1;
        for(int i = 1; i < n; i++) {
            ans = Integer.max(ans, maxAi + values[i] - i);
            maxAi = Integer.max(maxAi, values[i] + i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {8,1,5,2,6};

        int ans = maxScoreSightseeingPair(nums);

        System.out.println(ans);
    }
}
