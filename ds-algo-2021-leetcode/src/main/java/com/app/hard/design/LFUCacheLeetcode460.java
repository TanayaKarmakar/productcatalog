package com.app.hard.design;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCacheLeetcode460 {
    static class LFUCache {
        static class Node {
            int key;
            int value;
            int count;

            public Node(int key, int value, int count) {
                this.key = key;
                this.value = value;
                this.count = count;
            }
        }

        private int currentCap;
        private int maxCap;
        private int leastFrequency;
        private Map<Integer, Node> map;
        private Map<Integer, List<Node>> mapBasedOnFreq;

        public LFUCache(int capacity) {
            map = new HashMap<>();
            mapBasedOnFreq = new HashMap<>();
            this.currentCap = 0;
            this.maxCap = capacity;
            this.leastFrequency = 1;
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            Node existingNode = map.get(key);
            mapBasedOnFreq.get(existingNode.count).remove(existingNode);
            if(existingNode.count == leastFrequency && mapBasedOnFreq.get(leastFrequency).isEmpty()) {
                leastFrequency++;
            }

            existingNode.count = existingNode.count + 1;
            if(!mapBasedOnFreq.containsKey(existingNode.count)) {
                mapBasedOnFreq.put(existingNode.count, new LinkedList<>());
            }
            mapBasedOnFreq.get(existingNode.count).add(existingNode);
            return existingNode.value;
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)) {
                Node newNode = new Node(key, value, 1);
                if(currentCap == maxCap) {
                    Node remNode = mapBasedOnFreq.get(leastFrequency).iterator().next();
                    map.remove(remNode.key);
                    mapBasedOnFreq.get(leastFrequency).remove(remNode);
                    currentCap--;
                }

                if(leastFrequency > 1) {
                    leastFrequency = 1;
                }
                if(!mapBasedOnFreq.containsKey(leastFrequency)) {
                    mapBasedOnFreq.put(leastFrequency, new LinkedList<>());
                }
                mapBasedOnFreq.get(leastFrequency).add(newNode);
                map.put(key, newNode);
                currentCap++;
            } else {
                Node existingNode = map.get(key);
                mapBasedOnFreq.get(existingNode.count).remove(existingNode);
                existingNode.count = existingNode.count + 1;
                if(!mapBasedOnFreq.containsKey(existingNode.count)) {
                    mapBasedOnFreq.put(existingNode.count, new LinkedList<>());
                }
                mapBasedOnFreq.get(existingNode.count).add(existingNode);
            }
        }
    }

    public static void main(String[] args) {

    }
}
