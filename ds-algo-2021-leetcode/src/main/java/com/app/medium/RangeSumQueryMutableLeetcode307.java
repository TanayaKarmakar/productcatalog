package com.app.medium;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */


class NumArray {
  int[] seg;
  int n;
  int[] nums;

  public NumArray(int[] nums) {
    this.nums = nums;
    n = nums.length;
    seg = new int[4 * n];
    build(0, n - 1, 0);
  }

  public void update(int index, int val) {
    nums[index] = val;
    update(0, n - 1, 0, val, index);
  }

  public int sumRange(int left, int right) {
    return query(0, n - 1, left, right, 0);
  }

  private int query(int low, int high, int left, int right, int indx) {
    if(low > high)
      return 0;
    if(low > right || high < left)
      return 0;
    if(low >= left && high <= right)
      return seg[indx];
    int mid = (low + high) >> 1;
    int leftChild = query(low, mid, left, right, 2 * indx + 1);
    int rightChild = query(mid + 1, high, left, right, 2 * indx + 1);
    return leftChild + rightChild;
  }

  private void update(int low, int high, int indx, int val, int i) {
    if(low == high) {
      seg[indx] = val;
      return;
    }
    int mid = (low + high) >> 1;
    if(i <= mid)
      update(low, mid, 2 * indx + 1, val, i);
    else
      update(mid + 1, high, 2 * indx + 2, val, i);
    seg[indx] = seg[2 * indx + 1] + seg[2 * indx + 2];
  }

  private void build(int low, int high, int indx) {
    if(low == high) {
      seg[indx] = nums[low];
      return;
    }
    int mid = (low + high) >> 1;
    build(low, mid, 2 * indx + 1);
    build(mid + 1, high, 2 * indx + 2);
    seg[indx] = seg[2 * indx + 1] + seg[2 * indx + 2];
  }
}
public class RangeSumQueryMutableLeetcode307 {
  public static void main(String[] args) {

  }
}
