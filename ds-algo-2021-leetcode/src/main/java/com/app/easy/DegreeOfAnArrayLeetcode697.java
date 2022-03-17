package com.app.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
class Degree {
    int deg;
    int start;
    int end;

    public Degree(int deg, int start, int end) {
        this.deg = deg;
        this.start = start;
        this.end = end;
    }
}

public class DegreeOfAnArrayLeetcode697 {
    private static int findShortestSubArray(int[] nums) {
        Map<Integer, Degree> degreeMap = new HashMap<>();

        int maxDeg = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(!degreeMap.containsKey(nums[i])) {
                degreeMap.put(nums[i], new Degree(0, -1,-1));
            }
            Degree val = degreeMap.get(nums[i]);
            val.deg = val.deg + 1;
            if(val.start == -1) {
                val.start = i;
            }
            val.end = i;
            degreeMap.put(nums[i], val);
            maxDeg = Integer.max(maxDeg, val.deg);
        }

        int minLen = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Degree> entry: degreeMap.entrySet()) {
            Degree deg = entry.getValue();
            if(deg.deg == maxDeg) {
                minLen = Integer.min(minLen, (deg.end - deg.start + 1));
            }
        }
        return minLen;
    }

    public static void main(String[] args) {

    }
}
