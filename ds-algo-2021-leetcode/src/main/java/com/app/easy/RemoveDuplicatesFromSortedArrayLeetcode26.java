package com.app.easy;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */
public class RemoveDuplicatesFromSortedArrayLeetcode26 {
  private static int removeDuplicates(int[] nums) {
    if(nums.length <= 1)
      return nums.length;
    int n = nums.length;
    int len = 1;

    int i = 0;
    while(i < n) {
      int j = i + 1;
      while(j < n && nums[i] == nums[j]) {
        j++;
      }
      if(j < n) {
        nums[len] = nums[j];
        len++;
      }
      i = j;

    }
    return len;
  }


  public static void main(String[] args) {
    int[] nums = {1,1,2};
    int len = removeDuplicates(nums);

    System.out.println(len);
  }
}
