package com.app.medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author t0k02w6 on 05/10/21
 * @project ds-algo-2021
 */
class Item {
    private int key;
    private int value;

    public Item(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class LRUCache {
    private Map<Integer, Item> map;
    private Deque<Item> dq;
    private int maxCap;
    private int currentCap;

    public LRUCache(int capacity) {
        maxCap = capacity;
        currentCap = 0;
        map = new HashMap<>();
        dq = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Item item = map.get(key);
        dq.remove(item);
        dq.addFirst(item);
        return map.get(key).getValue();
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(currentCap >= maxCap) {
                Item itemToBeRemoved = dq.pollLast();
                map.remove(itemToBeRemoved.getKey());
                currentCap--;
            }
            Item newItem = new Item(key, value);
            map.put(key, newItem);
            dq.addFirst(newItem);
            currentCap++;
        } else {
            Item item = map.get(key);
            dq.remove(item);
            Item newItem = new Item(key, value);
            map.put(key, newItem);
            dq.addFirst(newItem);
        }
    }
}


public class LRUCacheLeetcode146 {

}
