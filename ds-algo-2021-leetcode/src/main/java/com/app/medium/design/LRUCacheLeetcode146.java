package com.app.medium.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */

class LRUCache {
  static class Item {
    int key;
    int value;

    public Item(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private Map<Integer, Item> itemMap;
  private Deque<Item> items;
  private int maxCap;
  private int currentCap;

  public LRUCache(int capacity) {
    this.itemMap = new HashMap<>();
    this.items = new LinkedList<>();
    this.maxCap = capacity;
    this.currentCap = 0;
  }

  public int get(int key) {
    if(!itemMap.containsKey(key))
      return -1;
    return itemMap.get(key).value;
  }

  public void put(int key, int value) {
    if(!itemMap.containsKey(key)) {
      Item newItem = new Item(key, value);
      if(currentCap >= maxCap) {
        Item itemToBeRemoved = items.pollLast();
        itemMap.remove(itemToBeRemoved.key);
        currentCap--;
      }
      itemMap.put(key, newItem);
      items.addFirst(newItem);
      currentCap++;
    } else {
      Item existingItem = itemMap.get(key);
      items.remove(existingItem);

      existingItem.value = value;
      itemMap.put(key, existingItem);
      items.addFirst(existingItem);
    }
  }
}

public class LRUCacheLeetcode146 {
  public static void main(String[] args) {

  }
}
