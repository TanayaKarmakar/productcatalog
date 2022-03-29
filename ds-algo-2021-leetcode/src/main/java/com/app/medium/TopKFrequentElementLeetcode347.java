package com.app.medium;

import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
class FrequencyComparator implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o2.second - o1.second;
    }
}

public class TopKFrequentElementLeetcode347 {
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> pQ = new PriorityQueue<>(new FrequencyComparator());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Pair<Integer, Integer> pair = new Pair<>(entry.getKey(), entry.getValue());
            pQ.add(pair);
        }

        int[] result = new int[k];
        int i = 0;
        while(i < k && !pQ.isEmpty()) {
            Pair<Integer, Integer> pair = pQ.poll();
            result[i++] = pair.first;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
