package com.app.medium;

import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */

class LRUCache {
    private Map<Integer, Pair<Integer, Integer>> map;
    private Deque<Pair<Integer, Integer>> queue;
    private int maxCap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        maxCap = capacity;

    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Pair<Integer, Integer> pair = map.get(key);
        queue.remove(pair);
        queue.addFirst(pair);
        return pair.second;
    };

    public void put(int key, int value) {
        Pair<Integer, Integer> newPair = new Pair<>(key, value);
        if(!map.containsKey(key)) {
            if(queue.size() == maxCap) {
                Pair<Integer, Integer> remPair = queue.removeLast();
                map.remove(remPair.first);
            }
            map.put(key, newPair);
            queue.addFirst(newPair);
        } else {
            Pair<Integer, Integer> currPair = map.get(key);
            queue.remove(currPair);
            currPair.second = value;
            map.put(key, currPair);
            queue.addFirst(currPair);
        }

    }
}

public class LRUCacheLeetcode146 {
    public static void main(String[] args) {

    }
}
