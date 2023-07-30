package com.app.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author t0k02w6 on 27/07/23
 * @project ds-algo-2021-leetcode
 */
public class ReconstructItineraryLeetcode332 {
  private static List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> adjList = new HashMap<>();

    for(List<String> ticket: tickets) {
      String src = ticket.get(0);
      String dest = ticket.get(1);

      if(!adjList.containsKey(src))
        adjList.put(src, new PriorityQueue<>());
      adjList.get(src).add(dest);
    }

    Stack<String> stack = new Stack<>();
    dfs(adjList, stack, "JFK");

    List<String> result = new ArrayList<>();
    while(!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }

  private static void dfs(Map<String, PriorityQueue<String>> adjList, Stack<String> stack, String start) {
    while(adjList.containsKey(start) && adjList.get(start).size() > 0) {
      String neighbor = adjList.get(start).remove();
      dfs(adjList, stack, neighbor);
    }
    stack.push(start);
  }


  public static void main(String[] args) {
    List<List<String>> itinerary = new ArrayList<>();
    List<String> it1 = new ArrayList<>();
    it1.add("MUC");
    it1.add("LHR");
    itinerary.add(it1);

    it1 = new ArrayList<>();
    it1.add("JFK");
    it1.add("MUC");
    itinerary.add(it1);

    it1 = new ArrayList<>();
    it1.add("SFO");
    it1.add("SJC");
    itinerary.add(it1);

    it1 = new ArrayList<>();
    it1.add("LHR");
    it1.add("SFO");
    itinerary.add(it1);

    List<String> result = findItinerary(itinerary);

    System.out.println(result);
  }
}
