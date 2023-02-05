package com.app.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */

class MedianFinder {
  private PriorityQueue<Integer> maxQ;
  private PriorityQueue<Integer> minQ;

  public MedianFinder() {
    maxQ = new PriorityQueue<>(Collections.reverseOrder());
    minQ = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if(maxQ.size() == minQ.size()) {
      if(maxQ.isEmpty() || minQ.peek() > num) {
        maxQ.add(num);
      } else {
        if(num > minQ.peek()) {
          maxQ.add(minQ.poll());
          minQ.add(num);
        }
      }
    } else if(maxQ.size() > minQ.size()){
      if(num < maxQ.peek()) {
        minQ.add(maxQ.poll());
        maxQ.add(num);
      } else {
        minQ.add(num);
      }
    }
  }

  public double findMedian() {
    if(!maxQ.isEmpty() && !minQ.isEmpty() && maxQ.size() == minQ.size())
      return (maxQ.peek() + minQ.peek()) / (double)2;
    else
      return maxQ.peek();
  }
}

public class FindMedianFromTheDataStreamLeetcode295 {
  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);    // arr = [1]
    medianFinder.addNum(2);    // arr = [1, 2]
    System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(3);    // arr[1, 2, 3]
    System.out.println(medianFinder.findMedian());
  }
}
