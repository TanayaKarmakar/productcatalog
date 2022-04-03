package com.app.medium;

import com.app.common.Triplet;

import java.util.*;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class ExclusiveTimeOfFunctionsLeetcode636 {
    private static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Triplet<Integer, String, Integer>> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[n];
        int prev = 0;
        int timeElapsed = 0;
        for(String log: logs){
           String[] logToken = log.split(":");
           int id = Integer.parseInt(logToken[0]);
           String type = logToken[1];
           int timeStamp = Integer.parseInt(logToken[2]);
           if(type.equals("end")) {
               timeStamp++;
               stack.pop();
               timeElapsed = (timeStamp - prev);
               map.put(id, map.getOrDefault(id, 0) + timeElapsed);
           } else {
               if(!stack.isEmpty()) {
                   timeElapsed = (timeStamp - prev);
                   int key = stack.peek().getFirst();
                   map.put(key, map.getOrDefault(key, 0) + timeElapsed);
               }
               stack.push(new Triplet<>(id, type, timeStamp));
           }
           prev = timeStamp;
        }

        for(int i = 0; i < n; i++) {
            res[i] = map.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");

        int[] res = exclusiveTime(2, list);

        System.out.println(Arrays.toString(res));
    }
}
