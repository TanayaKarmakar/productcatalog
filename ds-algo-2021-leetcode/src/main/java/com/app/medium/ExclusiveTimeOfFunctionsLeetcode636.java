package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class ExclusiveTimeOfFunctionsLeetcode636 {
    static class Item {
        int id;
        String type;
        int ts;

        public Item(int id, String type, int ts) {
            this.id = id;
            this.type = type;
            this.ts = ts;
        }
    }
    private static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Item> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(String currentLog: logs) {
            String[] frag = currentLog.split(":");
            Item item = new Item(Integer.parseInt(frag[0]), frag[1], Integer.parseInt(frag[2]));
            if(item.type.equals("start")) {
                if(!stack.isEmpty()) {
                    Item peekItem = stack.peek();
                    int value = map.getOrDefault(peekItem.id, 0);
                    value += (item.ts - peekItem.ts);
                    map.put(peekItem.id, value);
                }
                stack.push(item);
            } else {
                Item popItem = stack.pop();
                int diff = item.ts - popItem.ts + 1;
                map.put(popItem.id, map.getOrDefault(popItem.id, 0) + diff);
                if(!stack.isEmpty()) {
                    stack.peek().ts = item.ts + 1;
                }
            }
        }
        int size = map.size();
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            result[i] = map.getOrDefault(i, 0);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int[] ans = exclusiveTime(2, logs);

        System.out.println(Arrays.toString(ans));
    }
}
