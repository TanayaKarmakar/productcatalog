package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */

class RandomizedSet {
  private Map<Integer, Integer> map;
  private List<Integer> numbers;

  public RandomizedSet() {
    map = new HashMap<>();
    numbers = new ArrayList<>();
  }

  public boolean insert(int val) {
    if(map.containsKey(val))
      return false;
    numbers.add(val);
    map.put(val, numbers.size() - 1);
    return true;
  }

  public boolean remove(int val) {
    if(!map.containsKey(val))
      return false;
    int indx = map.get(val);
    int lastValue = numbers.get(numbers.size() - 1);
    numbers.set(indx, lastValue);
    numbers.remove(numbers.size() - 1);
    map.put(lastValue, indx);
    map.remove(val);
    return true;
  }

  public int getRandom() {
    int start = 0;
    int end = numbers.size() - 1;
    int randIndx = (int)Math.floor(Math.random() * (end - start + 1) + start);
    return numbers.get(randIndx);
  }
}

public class InsertDeleteGetRandomLeetcode380 {
  public static void main(String[] args) {

  }
}
