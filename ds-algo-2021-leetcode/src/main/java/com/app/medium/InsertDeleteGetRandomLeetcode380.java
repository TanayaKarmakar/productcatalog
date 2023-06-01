package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */

class RandomizedSet {
  private Map<Integer, Integer> map;
  private List<Integer> list;
  //private Random random;

  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    //random = new Random();
  }

  public boolean insert(int val) {
    if(map.containsKey(val))
      return false;
    list.add(val);
    int indx = list.size() - 1;
    map.put(val, indx);
    return true;
  }

  public boolean remove(int val) {
    if(!map.containsKey(val))
      return false;
    if(list.size() == 1) {
      list.clear();
      map.remove(val);
    } else {
      int targetIndx = map.get(val);
      int lastIndx = list.size() - 1;
      int lastIndxItem = list.get(lastIndx);
      list.add(targetIndx, lastIndxItem);
      map.put(lastIndxItem, targetIndx);
      list.remove(lastIndx);
      map.remove(val);
    }
    return true;
  }

  public int getRandom() {
    if(list.isEmpty())
      return -1;
    int start = 0;
    int end = list.size();
    int randIndx = start + (int)(Math.random() * ((end - start) + 1));
    return list.get(randIndx);
  }
}

public class InsertDeleteGetRandomLeetcode380 {
  public static void main(String[] args) {

  }
}
