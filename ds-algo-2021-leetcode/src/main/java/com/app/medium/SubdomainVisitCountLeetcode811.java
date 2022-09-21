package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class SubdomainVisitCountLeetcode811 {
    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cpDomain: cpdomains) {
            String[] token = cpDomain.split("\\s+");

            Integer count = Integer.parseInt(token[0].trim());
            String domainToken = token[1];

           // map.put(domainToken, map.getOrDefault(domainToken, 0) + count);
            String[] domainTokens = domainToken.split("\\.");
            int size = domainTokens.length;
            StringBuilder sb = new StringBuilder();
            sb.append(domainTokens[size - 1]);
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0) + count);
            for(int i = size - 2; i >= 0; i--) {
                str = domainTokens[i] + "." + str;
                map.put(str, map.getOrDefault(str, 0) + count);
            }
        }
        List<String> finalResult = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            finalResult.add(entry.getValue() + " " + entry.getKey());
        }
        return finalResult;
    }

    public static void main(String[] args) {
        String[] domains = {"9001 discuss.leetcode.com"};
        List<String> finalResult = subdomainVisits(domains);

        System.out.println(finalResult);

        domains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        finalResult = subdomainVisits(domains);

        System.out.println(finalResult);
    }
}
