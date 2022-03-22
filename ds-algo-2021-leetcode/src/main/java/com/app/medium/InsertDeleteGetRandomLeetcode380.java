package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        int indx = list.size() - 1;
        map.put(val, indx);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int indx = map.get(val);
        int lastItem = list.get(list.size() - 1);
        list.set(indx, lastItem);
        map.put(lastItem, indx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int start = 0;
        int end = list.size() - 1;
        int indx = (int) ((Math.random() * (end - start)) + start);
        return list.get(indx);
    }
}

public class InsertDeleteGetRandomLeetcode380 {
    public static void main(String[] args) {

    }
}
