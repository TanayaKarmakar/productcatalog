package com.app.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
class AllOne {
  static class Node {
    Node prev;
    Node next;
    Set<String> keys;
    int freq;

    public Node(int freq) {
      this.freq = freq;
      this.keys = new HashSet<>();
    }
  }

  Node head;
  Node tail;
  Map<String, Node> map;

  public AllOne() {
    map = new HashMap<>();
  }

  public void inc(String key) {
    if(!map.containsKey(key)) {
      Node newNode = new Node(1);
      newNode.keys.add(key);
      if(head == null) {
        head = newNode;
        tail = newNode;
      } else {
        if(head.freq > 1) {
          head.prev = newNode;
          newNode.next = head;
          head = newNode;
        } else {
          head.keys.add(key);
        }
      }
      map.put(key, head);
    } else {
      Node existingNode = map.get(key);
      existingNode.keys.remove(key);

      if(existingNode.next == null) {
        Node newNode = new Node(existingNode.freq + 1);
        newNode.keys.add(key);
        existingNode.next = newNode;
        newNode.prev = existingNode;
        tail = newNode;
        map.put(key, tail);
      } else {
        if(existingNode.next.freq - existingNode.freq > 1) {
          Node newNode = new Node(existingNode.freq + 1);
          newNode.keys.add(key);
          newNode.prev = existingNode;
          newNode.next = existingNode.next;
          existingNode.next.prev = newNode;
          existingNode.next = newNode;
          map.put(key, existingNode);
        } else {
          existingNode.keys.remove(key);
          existingNode.next.keys.add(key);
          map.put(key, existingNode.next);

          if(existingNode.keys.isEmpty()) {
            removeNode(existingNode);
          }
        }
      }
    }
  }

  public void dec(String key) {
    if(!map.containsKey(key))
      return;

    Node existingNode = map.get(key);
    existingNode.keys.remove(key);

    if(existingNode == head) {
      Node newNode = new Node(existingNode.freq - 1);
      newNode.keys.add(key);
      head.prev = newNode;
      newNode.next = head;
      head = newNode;
      map.put(key, head);
    } else {
      if(existingNode.freq == 1) {
        map.remove(key);
        return;
      } else if(existingNode.freq - existingNode.prev.freq > 1) {
        Node newNode = new Node(existingNode.freq - 1);
        newNode.keys.add(key);
        newNode.prev = existingNode.prev;
        newNode.next = existingNode;
        existingNode.prev.next = newNode;
        existingNode.prev = newNode;
        map.put(key, existingNode);
      } else {
        existingNode.prev.keys.add(key);
        map.put(key, existingNode.prev);

        if(existingNode.keys.isEmpty()) {
          //removeNode
          removeNode(existingNode);
        }
      }
    }
  }

  private void removeNode(Node existingNode) {
    if(existingNode == head) {
      head = head.next;
      existingNode.next = null;
      if(head != null)
        head.prev = null;
    } else if(existingNode == tail) {
      tail = tail.prev;
      existingNode.prev = null;
      if(tail != null)
        tail.next = null;
    } else {
      Node prev = existingNode.prev;
      Node next = existingNode.next;
      prev.next = next;
      next.prev = prev;
      existingNode.prev = null;
      existingNode.next = null;
    }
  }


  public String getMaxKey() {
    return tail == null ? "": tail.keys.iterator().next();
  }

  public String getMinKey() {
    return head == null ? "": head.keys.iterator().next();
  }


}


public class AllOneDataStructureLeetcode432 {
  public static void main(String[] args) {
    AllOne allOne = new AllOne();
   // System.out.println("Incrementing hello");
    allOne.inc("hello");
    allOne.inc("hello");
    allOne.inc("leet");
    System.out.println(allOne.getMaxKey());
    System.out.println(allOne.getMinKey());
  }
}
