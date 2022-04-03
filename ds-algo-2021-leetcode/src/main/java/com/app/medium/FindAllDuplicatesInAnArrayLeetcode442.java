package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class FindAllDuplicatesInAnArrayLeetcode442 {
    private static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            while(nums[i] != (i + 1)) {
                int tmp = nums[i];
                if(nums[tmp - 1] == tmp)
                    break;
                int tmp1 = nums[tmp - 1];
                nums[i] = tmp1;
                nums[tmp - 1] = tmp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1))
                result.add(nums[i]);
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDuplicates(nums);

        System.out.println(res);
    }
}
