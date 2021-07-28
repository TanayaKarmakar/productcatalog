package com.app.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 27/07/21
 * @project ds-algo-2021
 */
public class CarFleetLeetcode853 {
    static class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        if(position.length < 2)
            return position.length;
        int n = position.length;
        Car[] cars = new Car[n];

        for(int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / (double) speed[i];
            cars[i] = new Car(position[i], time);
        }

        Arrays.sort(cars, (c1, c2) -> c2.position - c1.position);
        int numFleets = 1;
        int firstCarInFleet = 0;
        for(int i = 1; i < n; i++) {
            if(cars[i].time > cars[firstCarInFleet].time) {
                numFleets++;
                firstCarInFleet = i;
            }
        }
        return numFleets;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        int ans = carFleet(target, position, speed);

        System.out.println(ans);
     }
}
