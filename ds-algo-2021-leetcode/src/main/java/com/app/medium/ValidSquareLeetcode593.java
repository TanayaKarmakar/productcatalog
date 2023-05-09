package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 08/05/23
 * @project ds-algo-2021-leetcode
 */
public class ValidSquareLeetcode593 {
  private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    List<int[]> points = new ArrayList<>();
    points.add(p1);
    points.add(p2);
    points.add(p3);
    points.add(p4);

    Collections.sort(points, (pt1, pt2) -> {
      if(pt1[0] == pt2[0])
        return pt1[1] - pt2[1];
      return pt1[0] - pt2[0];
    });

    p1 = points.get(0);
    p2 = points.get(1);
    p3 = points.get(2);
    p4 = points.get(3);

    //boolean condition1 = ((p1[0] == p2[0]) && (p1[1] == p3[1]) && (p2[1] == p4[1]) && (p3[0] == p4[0]));

    int dist12 = dist(p1, p2);
    int dist24 = dist(p2, p4);
    int dist34 = dist(p3, p4);
    int dist31 = dist(p1, p3);
    int diag = dist(p1, p4);
    int antiDiag = dist(p2, p3);
    boolean condition2 = dist12 != 0 && (dist12 == dist24) && (dist24 == dist34) && (dist34 == dist31)
        && (dist31 == dist12) && (diag == antiDiag);

    return condition2;
  }

  private static int dist(int[] p1, int[] p2) {
    return ((p1[0] - p2[0]) * (p1[0] - p2[0])) + ((p1[1] - p2[1]) * (p1[1] - p2[1]));
  }

  public static void main(String[] args) {
    int[] p1 = {0,0};
    int[] p2 = {1,1};
    int[] p3 = {1,0};
    int[] p4 = {0,1};

    System.out.println(validSquare(p1, p2, p3, p4));
  }
}
