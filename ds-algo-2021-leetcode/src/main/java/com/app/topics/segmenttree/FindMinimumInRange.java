package com.app.topics.segmenttree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 03/12/22
 * @project ds-algo-2021
 */
public class FindMinimumInRange {
  private static void build(int[] nums, int[] seg, int low, int high, int indx) {
    if(low == high) {
      seg[indx] = nums[low];
      return;
    }
    int mid = (low + high) >> 1;
    build(nums, seg, low, mid, 2 * indx + 1);
    build(nums, seg, mid + 1, high, 2 * indx + 2);
    seg[indx] = Integer.min(seg[2 * indx + 1], seg[2 * indx + 2]);
  }

  private static void update(int indx, int low, int high, int i, int val, int[] seg) {
    if(low == high) {
      seg[indx] = val;
      return;
    }
    int mid = (low + high) >> 1;
    if(i <= mid)
      update(2 * indx + 1, low, mid, i, val, seg);
    else
      update(2 * indx + 2, mid + 1, high, i, val, seg);
    seg[indx] = Integer.min(seg[2 * indx + 1], seg[2 * indx + 2]);
  }

  private static int query(int[] seg, int low, int high, int l, int r, int indx) {
    if(low > r || high < l)
      return Integer.MAX_VALUE;
    if(low >= l && high <= r) {
      return seg[indx];
    }
    int mid = (low + high) >> 1;
    int left = query(seg, low, mid, l, r, 2 * indx + 1);
    int right = query(seg, mid + 1, high, l, r, 2 * indx + 2);
    return Integer.min(left, right);
  }

  public static void main(String[] args) {
    int[] nums = {1,4,3,2,56,7,8};
    int n = nums.length;
    int[] seg = new int[4 * n];
    build(nums, seg, 0, n - 1, 0);


    System.out.println(Arrays.toString(seg));

    Scanner scanner = new Scanner(System.in);
    int q = scanner.nextInt();
    while(q-- > 0) {
      int l = scanner.nextInt();
      int r = scanner.nextInt();
      int ans = query(seg, 0, n - 1, l, r, 0);
      System.out.println(ans);
    }
  }
}
