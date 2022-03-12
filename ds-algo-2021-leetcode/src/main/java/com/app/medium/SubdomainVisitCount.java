package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 11/03/22
 * @project ds-algo-2021
 */
public class SubdomainVisitCount {
    private static void addData(Map<String, Integer> map, String key, Integer value) {
        if(!map.containsKey(key)) {
            map.put(key, 0);
        }
        int val = map.getOrDefault(key, 0);
        val += value;
        map.put(key, val);
    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainMap = new HashMap<>();
        for(String domain: cpdomains) {
            String[] domainTokens = domain.split("\\s+");
            Integer count = Integer.parseInt(domainTokens[0].trim());
            String[] domainValues = domainTokens[1].split("\\.");
            String ss = domainValues[domainValues.length - 1];
            for(int i = domainValues.length - 2; i >= 0; i--) {
                if(!ss.isEmpty()) {
                    addData(domainMap, ss, count);
                }
                ss = domainValues[i] + "." + ss;
            }
            addData(domainMap, ss, count);
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: domainMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"9001 discuss.leetcode.com"};

        List<String> res = subdomainVisits(str);
        System.out.println(res);
    }
}
