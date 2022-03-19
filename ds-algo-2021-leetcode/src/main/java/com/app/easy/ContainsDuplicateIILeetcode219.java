package com.app.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class ContainsDuplicateIILeetcode219 {
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            if(map.get(nums[i]).size() > 1) {
                List<Integer> indices = map.get(nums[i]);
                for(int j = 1; j < indices.size(); j++) {
                    if(indices.get(j) - indices.get(j - 1) <= k)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
