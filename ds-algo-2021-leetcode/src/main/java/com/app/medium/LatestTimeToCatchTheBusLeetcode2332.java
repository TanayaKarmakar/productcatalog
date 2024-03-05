package com.app.medium;

import java.util.Arrays;

public class LatestTimeToCatchTheBusLeetcode2332 {
    private static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int bLen = buses.length;
        int pLen = passengers.length;

        if(passengers[0] > buses[bLen - 1])
            return buses[bLen - 1];

        int i = 0;
        int j = 0;
        int occupiedSeats = 0;
        int result = passengers[0] - 1;

        while(i < bLen) {
            occupiedSeats = 0;
            while(j < pLen && occupiedSeats < capacity && passengers[j] <= buses[i]) {
                if(j > 0 && passengers[j] - passengers[j - 1] > 1) {
                    result = passengers[j] - 1;
                }
                j++;
                occupiedSeats++;
            }

            if(j > 0 && occupiedSeats < capacity && buses[i] != passengers[j - 1]) {
                result = buses[i];
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] buses = {10,20};
        int[] passengers = {2,17,18,19};
        int capacity = 2;

        int ans = latestTimeCatchTheBus(buses, passengers, capacity);

        System.out.println(ans);
    }
}
