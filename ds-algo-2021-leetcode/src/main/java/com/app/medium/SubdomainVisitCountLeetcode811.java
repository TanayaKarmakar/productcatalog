package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCountLeetcode811 {
    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> subdomainMap = new HashMap<>();

        for(String currentDomain: cpdomains) {
            String[] tokens = currentDomain.split("\\s+");
            int visitCount = Integer.parseInt(tokens[0]);

            String subdomain = tokens[1];
            String[] domainTokens = subdomain.split("\\.");

            StringBuilder sb = new StringBuilder();
            for(int i = domainTokens.length - 1; i >= 0; i--) {
                if(sb.length() == 0) {
                    sb.append(domainTokens[i]);
                } else {
                    String str = sb.toString();
                    sb = new StringBuilder();
                    sb.append(domainTokens[i]);
                    sb.append(".");
                    sb.append(str);
                }
                subdomainMap.put(sb.toString(), subdomainMap.getOrDefault(sb.toString(), 0) + visitCount);
            }
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: subdomainMap.entrySet()) {
            String str = entry.getValue() + " " + entry.getKey();
            result.add(str);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
