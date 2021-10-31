package com.app.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 09/10/21
 * @project ds-algo-2021
 */
class DistanceItem implements Comparable<DistanceItem> {
    int[] points;
    int distance;

    public DistanceItem(int[] points, int distance) {
        this.distance = distance;
        this.points = points;
    }

    @Override
    public int compareTo(DistanceItem o) {
        return this.distance - o.distance;
    }
}

public class KClosestPointsToOriginLeetcode973 {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<DistanceItem> pQ = new PriorityQueue<>();
        for(int i = 0; i < points.length; i++) {
            int distance = calcDistance(points[i]);
            DistanceItem distanceItem = new DistanceItem(points[i], distance);
            pQ.add(distanceItem);
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k && !pQ.isEmpty(); i++) {
            result[i] = pQ.poll().points;
        }

        return result;
    }

    private static int calcDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2,2}};
        int[][] res = kClosest(points, 1);

        for(int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
