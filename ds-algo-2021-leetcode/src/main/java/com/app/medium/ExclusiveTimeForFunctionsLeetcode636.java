package com.app.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */
public class ExclusiveTimeForFunctionsLeetcode636 {
  static class LogItem {
    int id;
    String type;
    int startTime;

    public LogItem(int id, String type, int startTime) {
      this.id = id;
      this.type = type;
      this.startTime = startTime;
    }
  }

  private static int[] exclusiveTime(int n, List<String> logs) {
    Stack<LogItem> stack = new Stack<>();

    Map<Integer, Integer> map = new HashMap<>();
    for(String log: logs) {
      String[] tokens = log.split("\\:");
      LogItem currentLogItem = new LogItem(Integer.parseInt(tokens[0]), tokens[1],
          Integer.parseInt(tokens[2]));
      if(stack.isEmpty()) {
        stack.push(currentLogItem);
      } else if(currentLogItem.type.equals("start")) {
        LogItem prevItem = stack.peek();
        int value = map.getOrDefault(prevItem.id, 0);
        value += (currentLogItem.startTime - prevItem.startTime);
        map.put(prevItem.id, value);
        stack.push(currentLogItem);
      } else {
        LogItem matchingStartItem = stack.pop();
        int totalTimeOfExec = currentLogItem.startTime - matchingStartItem.startTime + 1;
        map.put(currentLogItem.id, map.getOrDefault(currentLogItem.id, 0) + totalTimeOfExec);
        if(!stack.isEmpty()) {
          stack.peek().startTime = currentLogItem.startTime + 1;
        }
      }
    }

    int[] result = new int[n];
    for(int i = 0; i < n; i++) {
      result[i] = map.getOrDefault(i, 0);
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 2;
    String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};

    System.out.println(Arrays.toString(exclusiveTime(n , Arrays.asList(logs))));
  }
}
