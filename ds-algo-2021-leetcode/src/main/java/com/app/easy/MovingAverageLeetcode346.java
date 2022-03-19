package com.app.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
class MovingAverage {
    List<Integer> list;
    int r;
    int sum;
    int windowSize;

    public MovingAverage(int size) {
        list = new ArrayList<>();
        r = 0;
        sum = 0;
        windowSize = size;
    }

    public double next(int val) {
        sum += val;
        list.add(sum);
        int lastIndx = list.size() - 1;
        int l = 0;
        if((lastIndx - l + 1) > windowSize) {
            l = lastIndx - windowSize;
            return (list.get(lastIndx) - list.get(l)) / (double)windowSize;
        } else {
            return list.get(lastIndx)/(double)list.size();
        }
    }
}


public class MovingAverageLeetcode346 {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }
}
