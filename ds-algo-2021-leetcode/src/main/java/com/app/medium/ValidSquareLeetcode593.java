package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        int d1 = dist(p1, p2);
        int d2 = dist(p2, p4);
        int d3 = dist(p3, p4);
        int d4 = dist(p1, p3);
        int diag = dist(p1, p4);
        int antiDiag = dist(p2, p3);

        return d1 != 0 && d1 == d2 && d2 == d3 && d3 == d4 && d4 == d1
                && diag == antiDiag;

    }

    private static int dist(int[] pt1, int[] pt2) {
        return (pt1[0] - pt2[0]) * (pt1[0] - pt2[0])
                + (pt1[1] - pt2[1]) * (pt1[1] - pt2[1]);
    }

    public static void main(String[] args) {

    }
}
