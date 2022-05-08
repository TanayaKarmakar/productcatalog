package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */


public class SmallestCommonRegionLeetcode1257 {
    private static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> childParentMap = new HashMap<>();

        for(List<String> currentRegion: regions) {
            String container = currentRegion.get(0);
            List<String> children = currentRegion.subList(1, currentRegion.size());

            if(!childParentMap.containsKey(container))
                childParentMap.put(container, null);
            for(String currentChild: children)
                childParentMap.put(currentChild, container);
        }

        String copyRegion1 = region1;
        String copyRegion2 = region2;
        while(!Objects.equals(region1, region2)) {
            region1 = (region1 == null) ? copyRegion2: childParentMap.get(region1);
            region2 = (region2 == null) ? copyRegion1: childParentMap.get(region2);
        }
        return region1;
    }

    public static void main(String[] args) {
        List<List<String>> regions = new ArrayList<>();
        List<String> region1 = new ArrayList<>();
        region1.add("Earth");
        region1.add("North America");
        region1.add("South America");
        regions.add(region1);

        List<String> region2 = new ArrayList<>();
        region2.add("North America");
        region2.add("United States");
        region2.add("Canada");
        regions.add(region2);

        List<String> region3 = new ArrayList<>();
        region3.add("United States");
        region3.add("New York");
        region3.add("Boston");
        regions.add(region3);

        List<String> region4 = new ArrayList<>();
        region4.add("Canada");
        region4.add("Ontario");
        region4.add("Quebec");
        regions.add(region4);

        List<String> region5 = new ArrayList<>();
        region5.add("South America");
        region5.add("Brazil");
        regions.add(region5);

        System.out.println(findSmallestRegion(regions, "Quebec", "New York"));
        System.out.println(findSmallestRegion(regions, "Canada", "Quebec"));

    }
}
