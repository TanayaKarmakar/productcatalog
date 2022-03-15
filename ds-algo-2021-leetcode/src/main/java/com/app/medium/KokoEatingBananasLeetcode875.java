package com.app.medium;

/**
 * @author t0k02w6 on 12/03/22
 * @project ds-algo-2021
 */
public class KokoEatingBananasLeetcode875 {
    private static int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            min = Integer.min(piles[i], min);
            max = Integer.max(piles[i], max);
        }
        int start = min;
        int end = max;
        int finalAns = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) >> 1;
            int calcHour = 0;
            for(int i = 0; i < piles.length; i++) {
               int add = 1;
               if(piles[i] > mid) {
                   int r = (piles[i] % mid);
                   add += (r != 0 ? 1 : 0);
               }
                calcHour += add;
            }
            if(calcHour > h) {
                start = mid + 1;
            } else {
                //if(calcHour == h) {
                    finalAns = Integer.min(finalAns, mid);
                //}
                end = mid - 1;
            }
        }
        return finalAns;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
