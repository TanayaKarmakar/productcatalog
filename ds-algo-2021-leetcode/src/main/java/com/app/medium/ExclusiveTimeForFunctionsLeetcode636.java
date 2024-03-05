package com.app.medium;

import java.util.*;

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
        int[] res = new int[n];

        for(String log: logs) {
            String[] tokens = log.split(":");
            int id = Integer.parseInt(tokens[0]);
            int startTime = Integer.parseInt(tokens[2]);
            LogItem logItem = new LogItem(id, tokens[1], startTime);
            if(stack.isEmpty()) {
                stack.push(logItem);
            } else if(logItem.type.equals("start")) {
                LogItem previousItem = stack.peek();
                int value = map.getOrDefault(previousItem.id, 0);
                value += (logItem.startTime - previousItem.startTime);
                map.put(previousItem.id, value);
                stack.push(logItem);
            } else {
                LogItem matchingItem = stack.pop();
                int execTime = map.getOrDefault(matchingItem.id, 0);
                execTime += (logItem.startTime - matchingItem.startTime) + 1;
                map.put(matchingItem.id, execTime);
                if(!stack.isEmpty())
                    stack.peek().startTime = logItem.startTime + 1;
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            res[entry.getKey()] = entry.getValue();
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int n = 2;

        int[] res = exclusiveTime(n, logs);

        System.out.println(Arrays.toString(res));
    }
}
