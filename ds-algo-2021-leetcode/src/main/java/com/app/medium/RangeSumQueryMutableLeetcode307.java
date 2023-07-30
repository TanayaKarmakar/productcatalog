package com.app.medium;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
class NumArray {
  private int[] nums;
  private int[] segTree;

  public NumArray(int[] nums) {
    this.nums = nums;
    this.segTree = new int[4 * nums.length];
    buildTree(nums, segTree, 0, nums.length - 1, 1);
  }

  public void update(int index, int val) {
    update(nums, segTree, 0, nums.length - 1, index, val, 1);
  }

  public int sumRange(int left, int right) {
    return sumRange(segTree, 0, nums.length - 1, left, right, 1);
  }

  private int sumRange(int[] segTree, int start, int end, int left, int right, int treeIndx) {
    if(start > end)
      return 0;
    if(right < start || left > end)
      return 0;
    if(start >= left && end <= right)
      return segTree[treeIndx];
    int mid = (start + end) >> 1;
    int lSumRange = sumRange(segTree, start, mid, left, right, 2 * treeIndx + 1);
    int rSumRange = sumRange(segTree, mid + 1, end, left, right, 2 * treeIndx + 2);
    return lSumRange + rSumRange;
  }

  private void update(int[] nums, int[] segTree, int start, int end, int updateIndx,int value, int treeIndx) {
    if(start == end) {
      nums[updateIndx] = value;
      segTree[treeIndx] = value;
      return;
    }
    int mid = (start + end) >> 1;
    if(mid > updateIndx)
      update(nums, segTree, start, mid, updateIndx, value, 2 * treeIndx + 1);
    else
      update(nums, segTree, mid + 1, end, updateIndx, value, 2 * treeIndx + 2);
    segTree[treeIndx] = segTree[2 * treeIndx + 1] + segTree[2 * treeIndx + 2];
  }

  private void buildTree(int[] nums, int[] segTree, int start, int end, int treeIndx) {
    if(start == end) {
      segTree[treeIndx] = nums[start];
      return;
    }
    int mid = (start + end) >> 1;
    buildTree(nums, segTree, start, mid, 2 * treeIndx + 1);
    buildTree(nums, segTree, mid + 1, end, 2 * treeIndx + 2);
    segTree[treeIndx] = segTree[2 * treeIndx + 1] + segTree[2 * treeIndx + 2];
  }

}

public class RangeSumQueryMutableLeetcode307 {
  public static void main(String[] args) {

  }
}
