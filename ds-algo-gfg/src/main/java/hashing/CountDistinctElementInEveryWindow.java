package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 09/05/22
 * @project ds-algo-2021
 */
public class CountDistinctElementInEveryWindow {
    private static List<Integer> countDistinct(int[] nums, int windowSize) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        for(right = 0; right < windowSize; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        }

        while(right < n) {
            res.add(map.size());
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;

            int val = map.get(nums[left]);
            val--;
            if(val == 0)
                map.remove(nums[left]);
            else
                map.put(nums[left], val);
            left++;
        }

        res.add(map.size());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,10,5,3,20,5};
        int k = 4;
        List<Integer> res = countDistinct(nums, k);

        System.out.println(res);
    }
}
