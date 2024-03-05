package com.app.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOriginLeetcode973 {
    static class PointItem implements Comparable<PointItem> {
        int[] point;
        int distFromOrigin;

        public PointItem(int[] point, int distFromOrigin) {
            this.point = point;
            this.distFromOrigin = distFromOrigin;
        }

        @Override
        public int compareTo(PointItem o) {
            return this.distFromOrigin - o.distFromOrigin;
        }
    }

    private static int dist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointItem> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++) {
            PointItem pointItem = new PointItem(points[i], dist(points[i]));
            pQ.add(pointItem);
        }

        for(int i = k; i < points.length; i++) {
            int dist = dist(points[i]);
            if(pQ.peek().distFromOrigin > dist) {
                pQ.poll();
                pQ.add(new PointItem(points[i], dist));
            }
        }

        int[][] result = new int[k][];
        int i = 0;
        while(!pQ.isEmpty() && i < k) {
            result[i++] = pQ.poll().point;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;

        int[][] result = kClosest(points, k);

        for(int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
