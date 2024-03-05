package com.app.easy;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MovingAverageFromDataStreamLeetcode346 {
    static class MovingAverage {
        Deque<Integer> avgQ;
        int queueSize;

        public MovingAverage(int size) {
            this.avgQ = new LinkedList<>();
            this.queueSize = size;
        }

        public double next(int val) {
            int size = 0;
            if(avgQ.size() < queueSize) {
                avgQ.addLast(val);
                size = avgQ.size();
            } else {
                while(!avgQ.isEmpty() && avgQ.size() >= queueSize) {
                    avgQ.pollFirst();
                }
                avgQ.addLast(val);
                size = queueSize;
            }

            double value = 0;
            Iterator<Integer> qItr = avgQ.iterator();
            while(qItr.hasNext()) {
                value += qItr.next();
            }
            return value / (double)size;
        }
    }

    public static void main(String[] args) {

    }
}
