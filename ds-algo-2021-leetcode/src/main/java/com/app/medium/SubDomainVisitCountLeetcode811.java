package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 09/05/23
 * @project ds-algo-2021-leetcode
 */
public class SubDomainVisitCountLeetcode811 {
  private static List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> subDomainMap = new HashMap<>();

    for(String currentDomain: cpdomains) {
      String[] tokens = currentDomain.split("\\s+");
      int visitCount = Integer.parseInt(tokens[0]);
      String subdomainToken = tokens[1];
      String[] subdomainTokens = subdomainToken.split("\\.");
      StringBuilder sb = new StringBuilder();
      for(int i = subdomainTokens.length - 1; i >= 0; i--) {
        if(sb.length() == 0) {
          sb.append(subdomainTokens[i]);
        } else {
          String currentStr = sb.toString();
          sb = new StringBuilder();
          sb.append(subdomainTokens[i]);
          sb.append(".");
          sb.append(currentStr);
        }
        subDomainMap.put(sb.toString(), subDomainMap.getOrDefault(sb.toString(), 0) + visitCount);
      }
    }

    List<String> result = new ArrayList<>();
    for(Map.Entry<String, Integer> entry: subDomainMap.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      result.add("" + value + " " + key);
    }

    return result;
  }

  public static void main(String[] args) {
    String[] cpDomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

    List<String> result = subdomainVisits(cpDomains);

    System.out.println(result);
  }
}
