package com.app.topics.segmenttree.revision;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/05/23
 * @project ds-algo-2021-leetcode
 */
public class SegmentTree {
  private static int[] segmentTree;

  private static void buildSegmentTree(int[] nums) {
    int n = nums.length;
    segmentTree = new int[4 * n];
    buildTreeRec(nums, 0, n - 1, 0);
  }

  private static void buildTreeRec(int[] nums, int low, int high, int indx) {
    if(low == high) {
      segmentTree[indx] = nums[low];
      return;
    }
    int mid = (low + high) >> 1;
    buildTreeRec(nums, low, mid, 2 * indx + 1);
    buildTreeRec(nums, mid + 1, high, 2 * indx + 2);
    segmentTree[indx] = Integer.min(segmentTree[2 * indx + 1], segmentTree[2 * indx + 2]);
  }

  private static int query(int[] nums, int left, int right) {
    return queryRec(left, right, 0, nums.length - 1, 0);
  }

  private static int queryRec(int left, int right, int low, int high, int indx) {
    if(left > high || right < low)
      return Integer.MAX_VALUE;
    else if(low >= left && high <= right)
      return segmentTree[indx];
    int mid = (low + high) >> 1;
    int leftChild = queryRec(left, right, low, mid, 2 * indx + 1);
    int rightChild = queryRec(left, right, mid + 1, high, 2 * indx + 2);
    return Integer.min(leftChild, rightChild);
  }

  private static void updateAtIndex(int[] nums, int indx, int val) {
    nums[indx] = val;
    pointUpdateRec(0, nums.length - 1, 0, indx, val);
  }

  private static void pointUpdateRec(int low, int high, int treeIndx, int valIndx, int val) {
    if(low == high) {
      segmentTree[treeIndx] = val;
      return;
    }
    int mid = (low + high) >> 1;
    if(valIndx <= mid) {
      pointUpdateRec(low, mid, 2 * treeIndx + 1, valIndx, val);
    } else {
      pointUpdateRec(mid + 1, high, 2 * treeIndx + 2, valIndx, val);
    }
    segmentTree[treeIndx] = Integer.min(segmentTree[2 * treeIndx + 1], segmentTree[2 * treeIndx + 2]);
  }

  public static void main(String[] args) {
    int[] nums = {1,3,2,0,4,5};
    buildSegmentTree(nums);

    int left = 0;
    int right = 2;
    int ans = query(nums, left, right);
    System.out.println(ans);

    updateAtIndex(nums, 3, 8);
    left = 2;
    right = 4;
    ans = query(nums, left, right);
    System.out.println(ans);
  }
}
