package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */
public class SmallestCommonRegionLeetcode1257 {
  private static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    Map<String, String> regionMap = new HashMap<>();
    for(List<String> currentRegion: regions) {
      List<String> smallerRegions = currentRegion.subList(1, currentRegion.size());
      String parentRegion = currentRegion.get(0);
      if(!regionMap.containsKey(parentRegion)) {
        regionMap.put(parentRegion, null);
      }
      for(String currentSmallerRegion: smallerRegions) {
        regionMap.put(currentSmallerRegion, parentRegion);
      }
    }

    String copyRegion1 = region1;
    String copyRegion2 = region2;
    while(!Objects.equals(region1, region2)) {
      region1 = (region1 == null) ? copyRegion1: regionMap.get(region1);
      region2 = (region2 == null) ? copyRegion2: regionMap.get(region2);
      System.out.println("Region1 - " + region1 + ": Region2 - " + region2);
    }
    return region1;
  }

  public static void main(String[] args) {
    List<List<String>> regions = new ArrayList<>();
    List<String> region = new ArrayList<>();
    region.add("Earth");
    region.add("North America");
    region.add("South America");
    regions.add(region);

    region = new ArrayList<>();
    region.add("North America");
    region.add("United States");
    region.add("Canada");
    regions.add(region);

    region = new ArrayList<>();
    region.add("United States");
    region.add("New York");
    region.add("Boston");
    regions.add(region);

    region = new ArrayList<>();
    region.add("Canada");
    region.add("Ontario");
    region.add("Quebec");
    regions.add(region);

    region = new ArrayList<>();
    region.add("South America");
    region.add("Brazil");
    regions.add(region);

    String ans = findSmallestRegion(regions, "Canada", "South America");

    System.out.println(ans);
  }
}
