package com.app.medium;

import java.util.TreeMap;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class HandOfStraightsLeetcode846 {
    private static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();

        for(int i = 0; i < hand.length; i++) {
            tMap.put(hand[i], tMap.getOrDefault(hand[i], 0) + 1);
        }

        while(tMap.size() > 0) {
            int start = tMap.firstKey();
            for(int i = start; i < start + groupSize; i++) {
                if(!tMap.containsKey(i))
                    return false;
                int val = tMap.get(i);
                val--;
                if(val == 0)
                    tMap.remove(i);
                else
                    tMap.put(i, val);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        boolean ans = isNStraightHand(hand, groupSize);

        System.out.println(ans);
    }
}
