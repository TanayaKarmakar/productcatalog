package com.app.educative.io.dp.palindromicsubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 24/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestAlternatingSequenceTopDown {
  private static int las(int[] nums) {
    Map<String, Integer> map = new HashMap<>();

    int option1 = lasRec(nums, map, -1, 0, true);
    int option2 = lasRec(nums, map, -1, 0, false);
    return Integer.max(option1, option2);
  }

  private static int lasRec(int[] nums, Map<String, Integer> map, int prevIndx, int currIndx, boolean isAsc) {
    if(currIndx >= nums.length)
      return 0;
    String key = prevIndx + "|" + currIndx + "|" + isAsc;
    if(!map.containsKey(key)) {
      int c1 = 0;
      if(isAsc) {
        if(prevIndx == -1 || nums[prevIndx] < nums[currIndx]) {
          c1 = 1 + lasRec(nums, map, currIndx, currIndx + 1, !isAsc);
        }
      } else {
        if(prevIndx == -1 || nums[prevIndx] > nums[currIndx]) {
          c1 = 1 + lasRec(nums, map, currIndx, currIndx + 1, !isAsc);
        }
      }
      int c2 = lasRec(nums, map, prevIndx, currIndx + 1, isAsc);
      map.put(key, Integer.max(c1, c2));
    }
    return map.get(key);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    int ans = las(nums);
    System.out.println(ans);

    nums = new int[]{3,2,1,4};
    ans = las(nums);
    System.out.println(ans);

    nums = new int[]{1,3,2,4};
    ans = las(nums);
    System.out.println(ans);
  }
}
