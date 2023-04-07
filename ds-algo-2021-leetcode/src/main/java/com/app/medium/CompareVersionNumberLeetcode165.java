package com.app.medium;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class CompareVersionNumberLeetcode165 {
  private static int compareVersion(String version1, String version2) {
    String[] v1Arr = version1.split("\\.");
    String[] v2Arr = version2.split("\\.");

    int i = 0;
    int j = 0;
    int m = v1Arr.length;
    int n = v2Arr.length;


    while(i < m && j < n) {
      int v1 = Integer.parseInt(v1Arr[i].trim());
      int v2 = Integer.parseInt(v2Arr[i].trim());
      if(v1 > v2)
        return 1;
      else if(v1 < v2)
        return -1;
      i++;
      j++;
    }

    while(i < m) {
      int v1 = Integer.parseInt(v1Arr[i].trim());
      if(v1 > 0)
        return 1;
      i++;
    }

    while (j < n) {
      int v2 = Integer.parseInt(v2Arr[j].trim());
      if(v2 > 0)
        return -1;
      j++;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(compareVersion("1.01", "1.001"));
    System.out.println(compareVersion("1.0", "1.0.0"));
    System.out.println(compareVersion("0.1", "1.1"));
  }
}
