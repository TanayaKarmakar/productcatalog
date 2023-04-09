package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class CarFleetLeetcode853 {
  private static int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] carData = new double[n][2];

    for(int i = 0; i < n;i++) {
      carData[i][0] = position[i] * 1d;
      carData[i][1] = ((target - position[i]) * 1d) / speed[i];
    }

    Arrays.sort(carData, (a, b) -> (int) (a[0] - b[0]));
    double timeTaken = carData[n - 1][1];

    int totalFleet = 1;
    for(int i = n - 2; i >= 0; i--) {
      if(carData[i][1] > timeTaken) {
        totalFleet++;
        timeTaken = carData[i][1];
      }
    }
    return totalFleet;
  }

  public static void main(String[] args) {
    int target = 12;
    int[] position = {10,8,0,5,3};
    int[] speed = {2,4,1,1,3};

    int ans = carFleet(target, position, speed);

    System.out.println(ans);
  }
}
