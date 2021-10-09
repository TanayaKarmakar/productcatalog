package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 07/10/21
 * @project ds-algo-2021
 */
class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
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
        int lastItem = list.get(list.size() - 1);
        list.set(indx, lastItem);
        list.remove(list.size() - 1);
        map.put(lastItem, indx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int start = 0;
        int end = list.size() - 1;
        int rIndx = (int)(Math.random() * (end - start + 1) + start);
        return list.get(rIndx);
    }
}


public class InsertDeleteGetrandomLeetcode380 {
    public static void main(String[] args) {

    }
}
