package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 09/04/23
 * @project ds-algo-2021-leetcode
 */
public class CampusBikesLeetcode1057 {
  private static int[] assignBikes(int[][] workers, int[][] bikes) {
    TreeMap<Integer, List<int[]>> distMap = new TreeMap<>();

    for(int i = 0; i < workers.length; i++) {
      for(int j = 0; j < bikes.length; j++) {
        int d = dist(workers[i], bikes[j]);
        if(!distMap.containsKey(d))
          distMap.put(d, new ArrayList<>());
        distMap.get(d).add(new int[]{i, j});
      }
    }

    int n = workers.length;
    int[] result = new int[n];

    Arrays.fill(result, -1);

    Set<Integer> assignedBikes = new HashSet<>();
    for(Map.Entry<Integer, List<int[]>> entry: distMap.entrySet()) {
      List<int[]> values = entry.getValue();

      for(int[] val: values) {
        int v1 = val[0];
        int v2 = val[1];
        if(result[v1] == -1 && !assignedBikes.contains(v2)) {
          result[v1] = v2;
          assignedBikes.add(v2);
        }
      }
    }

    return result;
  }

  private static int dist(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }

  public static void main(String[] args) {

  }
}
