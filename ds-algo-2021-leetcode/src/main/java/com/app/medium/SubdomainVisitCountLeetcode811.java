package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 23/03/22
 * @project ds-algo-2021
 */
public class SubdomainVisitCountLeetcode811 {
    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for(String cpdomain: cpdomains) {
            String[] domainToken = cpdomain.split("\\s+");
            Integer count = Integer.parseInt(domainToken[0]);

            String[] fqdnToken = domainToken[1].split("\\.");
            String ss = fqdnToken[fqdnToken.length - 1];
            map.put(ss, map.getOrDefault(ss, 0) + count);
            for(int i = fqdnToken.length - 2; i >= 0; i--) {
                ss = fqdnToken[i] + "." + ss;
                map.put(ss, map.getOrDefault(ss, 0) + count);
            }
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] str = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = subdomainVisits(str);

        System.out.println(list);
    }
}
