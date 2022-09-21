package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
class LRUCache {
    Deque<Item> q;
    int maxCapacity;
    int currentCapacity;
    Map<Integer, Item> map;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currentCapacity = 0;
        this.q = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Item item = map.get(key);
        q.remove(item);
        q.addFirst(item);
        return item.value;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            Item newItem = new Item(key, value);
            if(currentCapacity == maxCapacity) {
                Item removedItem = q.removeLast();
                map.remove(removedItem.key);
            } else {
                currentCapacity++;
            }
            map.put(key, newItem);
            q.addFirst(newItem);
        } else {
            Item item = map.get(key);
            q.remove(item);
            item.value = value;
            map.put(key, item);
            q.addFirst(item);
        }
    }

    static class Item {
        int key;
        int value;

        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


public class LRUCacheLeetcode146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));        // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
