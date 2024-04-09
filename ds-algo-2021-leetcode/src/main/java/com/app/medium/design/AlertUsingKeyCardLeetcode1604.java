package com.app.medium.design;

import java.util.*;

public class AlertUsingKeyCardLeetcode1604 {
    private static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();

        int n = keyName.length;

        Set<String> result = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int minutes = convertToMinutes(keyTime[i]);
            String empName = keyName[i];
            if(!map.containsKey(empName)) {
                map.put(empName, new LinkedList<>());
            }
            map.get(empName).add(minutes);
        }

        for(Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            List<Integer> checkIns = entry.getValue();
            Collections.sort(checkIns);
            for(int i = 2; i < checkIns.size(); i++) {
                if(checkIns.get(i) - checkIns.get(i - 2) <= 60) {
                    result.add(entry.getKey());
                }
            }
        }

        List<String> finalResult = new ArrayList<>(result);

        Collections.sort(finalResult);
        return finalResult;
    }

    private static int convertToMinutes(String token) {
        String[] tokens = token.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        return hour * 60 + minutes;
    }

    public static void main(String[] args) {

    }
}
