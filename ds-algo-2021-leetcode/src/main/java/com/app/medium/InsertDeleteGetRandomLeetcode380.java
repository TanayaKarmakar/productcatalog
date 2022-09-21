package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        int size = list.size();
        map.put(val, size - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int indx = map.get(val);
        int lastValue = list.get(list.size() - 1);
        list.set(list.size() - 1, val);
        list.set(indx, lastValue);
        list.remove(list.size() - 1);
        map.put(lastValue, indx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int size = list.size();
        int indx = random.nextInt(size);
        return list.get(indx);
    }
}


public class InsertDeleteGetRandomLeetcode380 {
    public static void main(String[] args) {

    }
}
