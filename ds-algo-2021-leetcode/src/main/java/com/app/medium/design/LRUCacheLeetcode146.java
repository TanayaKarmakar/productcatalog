package com.app.medium.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheLeetcode146 {
    public static void main(String[] args) {

    }

    static class LRUCache {
        private Map<Integer, Item> map;
        private Deque<Item> dq;
        int maxCapacity;
        int currentCapacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            dq = new LinkedList<>();
            maxCapacity = capacity;
            currentCapacity = 0;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            Item item = map.get(key);
            dq.remove(item);
            dq.addFirst(item);
            return item.value;
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)) {
                Item newItem = new Item(key, value);
                if(currentCapacity == maxCapacity) {
                    Item leastUsedItem = dq.pollLast();
                    map.remove(leastUsedItem.key);
                } else {
                    currentCapacity++;
                }
                map.put(key, newItem);
                dq.addFirst(newItem);
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
}
