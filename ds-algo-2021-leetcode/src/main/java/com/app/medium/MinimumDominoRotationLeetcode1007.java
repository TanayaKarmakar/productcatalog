package com.app.medium;

import com.app.common.Pair;

/**
 * @author t0k02w6 on 11/04/22
 * @project ds-algo-2021
 */
public class MinimumDominoRotationLeetcode1007 {
    private static Pair<Integer, Integer> countMajority(int[] tops) {
        int mIndx = 0;
        int count = 1;
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] == tops[mIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    mIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] == tops[mIndx])
                count++;
        }
        if(count >= tops.length / 2)
            return new Pair<>(count, tops[mIndx]);
        return new Pair<>(-1, -1);
    }

    private static int minDominoRotations(int[] tops, int[] bottoms) {
        Pair<Integer, Integer> aMajCount = countMajority(tops);
        Pair<Integer, Integer> bMajCount = countMajority(bottoms);
        int n = tops.length;
        int count = 0;
        int majorityCount = 0;
        if(aMajCount.first == -1 && bMajCount.first == -1)
            return -1;
        else if(aMajCount.first > bMajCount.first) {
            majorityCount = aMajCount.first;
            for(int i = 0; i < n; i++) {
                if(tops[i] != aMajCount.second && bottoms[i] == aMajCount.second)
                    count++;
            }
        } else {
            majorityCount = bMajCount.first;
            for(int i = 0; i < n; i++) {
                if(bottoms[i] != bMajCount.second && tops[i] == bMajCount.second)
                    count++;
            }
        }
        if(majorityCount + count == n)
            return count;
        return -1;
    }

    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        int count = minDominoRotations(tops, bottoms);

        System.out.println(count);
    }
}
