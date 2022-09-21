package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 20/09/22
 * @project ds-algo-2021-leetcode
 */
public class PairOfSongsTotalDurationDivBy60Leetcode1010 {
    private static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
        }

        int count = 0;
        for(int i = 0; i < time.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
