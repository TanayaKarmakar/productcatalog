package com.app.medium;

/**
 * @author t0k02w6 on 09/06/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveDuplicatesFromSortedArrayIILeetcode80 {
  private static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int i = 0;
    while(i < n) {
      int j = i + 1;

      while(j < n && nums[i] == nums[j]) {
        j++;
      }

      if(j - i > 2) {
        int k = i + 2;
        while(k < j){
          nums[k] = Integer.MAX_VALUE;
          k++;
        }
      }
      i = j;
    }

    i = -1;
    for(int j = 0; j < n; j++) {
      if(nums[j] != Integer.MAX_VALUE) {
        i++;
        swap(nums, i, j);
      }
    }

    return (i + 1);
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3,3};

    int ans = removeDuplicates(nums);

    System.out.println("Len - " + ans);

    for(int i = 0; i < ans; i++) {
      System.out.println(nums[i]);
    }
  }
}
