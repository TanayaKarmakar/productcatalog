package com.app.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class ExclusiveTimeOfFunctionsLeetcode636 {
  static class ExecItem {
    int id;
    String type;
    int startTime;

    public ExecItem(int id, String type, int startTime) {
      this.id = id;
      this.type = type;
      this.startTime = startTime;
    }
  }

  private static int[] exclusiveTime(int n, List<String> logs) {
    Stack<ExecItem> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();

    for(String log: logs) {
      String[] tokens = log.split(":");
      ExecItem execItem = new ExecItem(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));
      if(stack.isEmpty()) {
        stack.push(execItem);
      } else if(execItem.type.equals("start")){
        ExecItem previousItem = stack.peek();
        int value = map.getOrDefault(previousItem.id, 0);
        value += (execItem.startTime - previousItem.startTime);
        map.put(previousItem.id, value);
        stack.push(execItem);
      } else {
        ExecItem matchingItem = stack.pop();
        int totalTimeOfExecution = execItem.startTime - matchingItem.startTime + 1;
        map.put(matchingItem.id, map.getOrDefault(matchingItem.id, 0) + totalTimeOfExecution);
        if(!stack.isEmpty())
          stack.peek().startTime = execItem.startTime + 1;
      }
    }

    int[] res = new int[n];
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      res[entry.getKey()] = entry.getValue();
    }
    return res;
  }

  public static void main(String[] args) {
    String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};
    int n = 2;
    int[] res = exclusiveTime(n, Arrays.asList(logs));
    System.out.println(Arrays.toString(res));
  }
}
