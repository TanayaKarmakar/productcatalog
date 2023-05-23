package com.app.hard.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author t0k02w6 on 21/05/23
 * @project ds-algo-2021-leetcode
 */
class LFUCache {
  private Map<Integer, Node> itemMap;
  private Map<Integer, LinkedHashSet<Node>> nodesBasedOnFreq;
  private int maxCapacity;
  private int currentCapacity;
  private int leastFrequency;

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
    Node node = itemMap.get(key);
    nodesBasedOnFreq.get(node.count).remove(node);
    if(node.count == leastFrequency && nodesBasedOnFreq.get(node.count).size() == 0) {
      this.leastFrequency++;
    }
    node.count = node.count + 1;
    if(!nodesBasedOnFreq.containsKey(node.count)) {
      nodesBasedOnFreq.put(node.count, new LinkedHashSet<>());
    }
    nodesBasedOnFreq.get(node.count).add(node);
    return node.value;
  }

  public void put(int key, int value) {
    if(!itemMap.containsKey(key)) {
      if(currentCapacity >= maxCapacity) {
        LinkedHashSet<Node> itemsFromLeastFrequency = nodesBasedOnFreq.get(this.leastFrequency);
        Node remNode = itemsFromLeastFrequency.iterator().next();
        itemsFromLeastFrequency.remove(remNode);
        itemMap.remove(remNode.key);
        currentCapacity--;
      }
      Node newNode = new Node(key, value, 1);
      if(this.leastFrequency > 1) {
        this.leastFrequency = 1;
      }
      if(!nodesBasedOnFreq.containsKey(this.leastFrequency)) {
        nodesBasedOnFreq.put(this.leastFrequency, new LinkedHashSet<>());
      }
      nodesBasedOnFreq.get(this.leastFrequency).add(newNode);
      itemMap.put(key, newNode);
      currentCapacity++;
    } else {
      Node node = itemMap.get(key);
      LinkedHashSet<Node> nodesFromFreqBucket = nodesBasedOnFreq.get(node.count);
      nodesFromFreqBucket.remove(node);
      node.count = node.count + 1;
      node.value = value;
      itemMap.put(key, node);
      if(!nodesBasedOnFreq.containsKey(node.count)) {
        nodesBasedOnFreq.put(node.count, new LinkedHashSet<>());
      }
      nodesBasedOnFreq.get(node.count).add(node);
    }
  }

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
}

public class LFUCacheLeetcode460 {
  public static void main(String[] args) {
    LFUCache lfu = new LFUCache(2);
    lfu.put(1, 1);
    lfu.put(2, 2);
    System.out.println(lfu.get(1));

    lfu.put(3, 3);
    System.out.println(lfu.get(2));
    System.out.println(lfu.get(3));
    lfu.put(4, 4);

    System.out.println(lfu.get(1));
    System.out.println(lfu.get(3));
    System.out.println(lfu.get(4));
  }
}
