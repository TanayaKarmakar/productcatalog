package com.app.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
class FirstUnique {
  static class QueueItem {
    int key;
    int value;

    public QueueItem(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  Map<Integer, QueueItem> map;
  Queue<QueueItem> queue;

  public FirstUnique(int[] nums) {
    map = new HashMap<>();
    queue = new LinkedList<>();
    insertItems(nums);
  }

  public int showFirstUnique() {
    if(queue.isEmpty())
      return -1;
    return queue.peek().key;
  }

  public void add(int value) {
    adjustItem(value);
  }

  private void insertItems(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      adjustItem(nums[i]);
    }
  }

  private void adjustItem(int key) {
    if(map.containsKey(key)) {
      QueueItem queueItem = map.get(key);
      queue.remove(queueItem);
      queueItem.value = queueItem.value + 1;
      map.put(key, queueItem);
    } else {
      QueueItem newQueueItem = new QueueItem(key, 1);
      map.put(key, newQueueItem);
      queue.add(newQueueItem);
    }
  }
}

public class FirstUniqueNumberLeetcode1429 {
  public static void main(String[] args) {

  }
}
