package com.app.medium;

import com.app.common.Pair;
import com.app.common.Triplet;

import java.util.*;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
class ValueComparator7 implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        if(o1.second == o2.second)
            return o1.first - o2.first;
        return o2.second - o1.second;
    }
}

public class FindKClosestElementsLeetcode658 {
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> pQ = new PriorityQueue<>(new ValueComparator7());
        for(int i = 0; i < k; i++) {
            Pair<Integer, Integer> pair = new Pair<>(arr[i], Math.abs(arr[i] - x));
            pQ.add(pair);
        }

        for(int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            if(pQ.peek().second > diff) {
                pQ.poll();
                pQ.add(new Pair<>(arr[i], diff));
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!pQ.isEmpty()) {
            list.add(pQ.poll().first);
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {

    }
}
