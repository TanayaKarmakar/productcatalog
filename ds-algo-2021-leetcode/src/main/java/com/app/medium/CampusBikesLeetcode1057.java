package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 05/07/23
 * @project ds-algo-2021-leetcode
 */
public class CampusBikesLeetcode1057 {
  private static int dist(int[] workers, int[] bikes) {
    return Math.abs(workers[0] - bikes[0]) + Math.abs(workers[1] - bikes[1]);
  }

  private static int[] assignBikes(int[][] workers, int[][] bikes) {
    TreeMap<Integer, List<int[]>> distMap = new TreeMap<>();

    for(int i = 0; i < workers.length; i++) {
      for(int j = 0; j < bikes.length; j++) {
        int dist = dist(workers[i], bikes[j]);
        if(!distMap.containsKey(dist)) {
          distMap.put(dist, new ArrayList<>());
        }
        distMap.get(dist).add(new int[]{i, j});
      }
    }

    Set<Integer> assignedBikes = new HashSet<>();
    int n = workers.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);

    for(Map.Entry<Integer, List<int[]>> entry: distMap.entrySet()) {
      List<int[]> values = entry.getValue();
      for(int[] workerToBikePos: values) {
        int workerPos = workerToBikePos[0];
        int bikePos = workerToBikePos[1];
        if(result[workerPos] == -1 && !assignedBikes.contains(bikePos)) {
          result[workerPos] = bikePos;
          assignedBikes.add(bikePos);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] workers = {{0,0},{2,1}};
    int[][] bikes = {{1,2},{3,3}};

    int[] result = assignBikes(workers, bikes);

    System.out.println(Arrays.toString(result));
  }
}
