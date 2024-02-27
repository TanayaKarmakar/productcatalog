package com.app.hard.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


class LFUCache {
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

    Map<Integer, Node> itemMap;
    Map<Integer, LinkedHashSet<Node>> nodesBasedOnFreq;
    int maxCapacity;
    int currentCapacity;
    int leastFrequency;

    public LFUCache(int capacity) {
        this.itemMap = new HashMap<>();
        this.nodesBasedOnFreq = new HashMap<>();
        this.maxCapacity = capacity;
        this.currentCapacity = 0;
        this.leastFrequency = 1;
    }

    public int get(int key) {
        if(!itemMap.containsKey(key))
            return -1;
        Node item = itemMap.get(key);
        nodesBasedOnFreq.get(item.count).remove(item);
        if(item.count == leastFrequency && nodesBasedOnFreq.get(item.count).isEmpty()) {
            leastFrequency++;
        }
        item.count = item.count + 1;
        if(!nodesBasedOnFreq.containsKey(item.count)) {
            nodesBasedOnFreq.put(item.count, new LinkedHashSet<>());
        }
        nodesBasedOnFreq.get(item.count).add(item);
        return item.value;
    }

    public void put(int key, int value) {
        if(!itemMap.containsKey(key)) {
            Node newItem = new Node(key, value, 1);
            if(currentCapacity >= maxCapacity) {
                LinkedHashSet<Node> nodes = nodesBasedOnFreq.get(leastFrequency);
                Node remNode = nodes.iterator().next();
                nodes.remove(remNode);
                itemMap.remove(remNode.key);
                currentCapacity--;
            }
            leastFrequency = 1;
            if(!nodesBasedOnFreq.containsKey(leastFrequency)) {
                nodesBasedOnFreq.put(leastFrequency, new LinkedHashSet<>());
            }
            nodesBasedOnFreq.get(leastFrequency).add(newItem);
            itemMap.put(newItem.key, newItem);
            currentCapacity++;
        } else {
            Node item = itemMap.get(key);
            nodesBasedOnFreq.get(item.count).remove(item);

            item.count = item.count + 1;
            if(!nodesBasedOnFreq.containsKey(item.count)) {
                nodesBasedOnFreq.put(item.count, new LinkedHashSet<>());
            }
            nodesBasedOnFreq.get(item.count).add(item);
            itemMap.put(key, item);
        }
    }
}
public class LFUCacheLeetcode460 {
    public static void main(String[] args) {

    }
}
