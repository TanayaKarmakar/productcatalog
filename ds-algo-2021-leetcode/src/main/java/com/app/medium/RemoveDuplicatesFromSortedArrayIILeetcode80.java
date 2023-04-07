package com.app.medium;

/**
 * @author t0k02w6 on 06/04/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveDuplicatesFromSortedArrayIILeetcode80 {
  private static int removeDuplicates(int[] nums) {
    int n = nums.length;
    for(int i = 0; i < n; i++) {
      int j = i + 1;
      while(j < n && nums[i] == nums[j]) {
        j++;
      }

      if(j - i > 2) {
        int k = i + 2;
        while(k < j) {
          nums[k++] = Integer.MAX_VALUE;
        }
      }
    }

    int i = -1;
    for(int j = 0; j < n; j++) {
      if(nums[j] != Integer.MAX_VALUE) {
        i++;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
      }
    }

    return (i + 1);
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3};

    int ans = removeDuplicates(nums);

    System.out.println(ans);

    nums = new int[] {0,0,1,1,1,1,2,3,3};
    ans = removeDuplicates(nums);

    System.out.println(ans);
  }
}
