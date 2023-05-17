package com.app.medium;

/**
 * @author t0k02w6 on 13/05/23
 * @project ds-algo-2021-leetcode
 */
public class FindTheDuplicateInAnArrayLeetcode287 {
  private static int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while(slow != fast);

    slow = 0;
    while(slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,4,2,2};

    int ans = findDuplicate(nums);

    System.out.println(ans);

    nums = new int[] {3,1,3,4,2};

    ans = findDuplicate(nums);

    System.out.println(ans);
  }
}
