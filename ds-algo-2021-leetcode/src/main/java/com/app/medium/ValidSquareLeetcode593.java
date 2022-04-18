package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class ValidSquareLeetcode593 {
    private static int dist(int[] p1, int[] p2) {
       return  (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[4][2];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;

        Arrays.sort(points, (pt1, pt2) -> {
            if(pt1[1] == pt2[1])
                return pt1[0] - pt2[0];
            else if(pt1[0] == pt2[0])
                return pt1[1] - pt2[1];
            else
                return pt1[0] - pt2[0];
        });

        p1 = points[0];
        p2 = points[1];
        p3 = points[2];
        p4 = points[3];

        int d1 = dist(p1, p2);
        int d2 = dist(p1, p3);
        int d3 = dist(p3, p4);
        int d4 = dist(p2, p4);

        int d5 = dist(p1, p4);
        int d6 = dist(p2, p3);

        return (d1 != 0 && d1 == d2 && d2 == d3 && d3 == d4 && d1 == d4 && d5 == d6);
    }

    public static void main(String[] args) {
        int[] p1 = {1, 0};
        int[] p2 = {-1, 0};
        int[] p3 = {0, 1};
        int[] p4 = {0, -1};

        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
