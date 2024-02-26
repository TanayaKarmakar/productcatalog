package com.app.medium;

import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int indx = map.get(val);
        int lastVal = list.get(list.size() - 1);
        list.set(indx, lastVal);
        map.put(lastVal, indx);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int start = 0;
        int end = list.size() - 1;
        int indx = random.nextInt(end - start + 1) + start;
        return list.get(indx);
    }
}

public class InsertDeleteGetRandomLeetcode380 {
    public static void main(String[] args) {

    }
}
