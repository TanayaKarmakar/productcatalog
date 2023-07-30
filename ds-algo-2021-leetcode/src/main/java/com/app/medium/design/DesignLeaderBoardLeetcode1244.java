package com.app.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 29/07/23
 * @project ds-algo-2021-leetcode
 */
class Leaderboard {
  static class Item implements Comparable<Item> {
    int playerId;
    int score;

    public Item(int playerId, int score) {
      this.playerId = playerId;
      this.score = score;
    }


    @Override
    public int compareTo(Item o) {
      return o.score - this.score;
    }
  }

  Map<Integer, Item> playerMap;
  PriorityQueue<Item> playerQ;

  public Leaderboard() {
    playerMap = new HashMap<>();
    playerQ = new PriorityQueue<>();
  }

  public void addScore(int playerId, int score) {
    if(!playerMap.containsKey(playerId)) {
      Item newItem = new Item(playerId, score);
      playerMap.put(playerId, newItem);
      playerQ.add(newItem);
    } else {
      Item item = playerMap.get(playerId);
      playerQ.remove(item);
      item.score += score;
      playerMap.put(playerId, item);
      playerQ.add(item);
    }
  }

  public int top(int K) {
    List<Item> items = new ArrayList<>();
    int totalSum = 0;
    while(K-- > 0) {
      Item item = playerQ.poll();
      totalSum += item.score;
      items.add(item);
    }
    playerQ.addAll(items);
    return totalSum;
  }

  public void reset(int playerId) {
    Item item = playerMap.get(playerId);
    playerQ.remove(item);
    item.score = 0;
    playerQ.add(item);
    playerMap.put(playerId, item);
  }
}

public class DesignLeaderBoardLeetcode1244 {
  public static void main(String[] args) {

  }
}
