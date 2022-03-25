package com.app.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
class Point {
    public int x;
    public int y;
    public double dist;

    public Point(int x, int y, double dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class ValueComparator2 implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        if(o1.dist == o2.dist)
            return 0;
        else if(o1.dist < o2.dist)
            return 1;
        else
            return -1;
    }
}


public class KClosestPointsToOriginLeetcode973 {
    private static double dist(int[] point) {
        return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
    }

    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pQ = new PriorityQueue<>(new ValueComparator2());
        for(int i = 0; i < k; i++) {
            Point point = new Point(points[i][0], points[i][1], dist(points[i]));
            pQ.add(point);
        }

        for(int i = k; i < points.length; i++) {
            int[] point = points[i];
            double dist = dist(point);
            if(pQ.peek().dist > dist) {
                pQ.poll();
                Point newPoint = new Point(point[0], point[1], dist);
                pQ.add(newPoint);
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!pQ.isEmpty()) {
            Point point = pQ.poll();
            result[i++] = new int[]{point.x, point.y};
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
