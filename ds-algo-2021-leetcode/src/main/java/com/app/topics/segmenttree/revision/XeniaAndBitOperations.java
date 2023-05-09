package com.app.topics.segmenttree.revision;

import java.util.Scanner;

/**
 * @author t0k02w6 on 07/05/23
 * @project ds-algo-2021-leetcode
 */

// true -- XOR false -- OR
public class XeniaAndBitOperations {
  private static int[] segTree;

  private static void buildTree(int []nums, int totalElements, int n) {
    segTree = new int[4 * totalElements];
    if(n % 2 == 0) {
      buildTreeRec(nums, 0, totalElements - 1, 0, true);
    } else {
      buildTreeRec(nums, 0, totalElements - 1, 0, false);
    }
  }

  private static void buildTreeRec(int[] nums, int low, int high, int treeIndx, boolean xor) {
    if(low == high) {
      segTree[treeIndx] = nums[low];
      return;
    }
    int mid = (low + high) >> 1;
    buildTreeRec(nums,low, mid, 2 *treeIndx + 1, !xor);
    buildTreeRec(nums, mid + 1, high, 2 * treeIndx + 2, !xor);
    if(xor) {
      segTree[treeIndx] = segTree[2 * treeIndx + 1] ^ segTree[2 * treeIndx + 2];
    } else {
      segTree[treeIndx] = segTree[2 * treeIndx + 1] | segTree[2 * treeIndx + 2];
    }
  }

  private static void update(int indx, int value, int[] nums, int n) {
    int totalElements = nums.length;
    if(n % 2 == 0) {
      updateRec(0, totalElements - 1, indx, value, 0, true);
    } else {
      updateRec(0, totalElements - 1, indx, value, 0, false);
    }
  }

  private static void updateRec(int low, int high, int indx, int value, int treeIndx, boolean xor) {
    if(low == high) {
      segTree[treeIndx] = value;
      return;
    }
    int mid = (low + high) >> 1;
    if(indx <= mid)
      updateRec(low, mid, indx, value, 2 * treeIndx + 1, !xor);
    else
      updateRec(mid + 1, high, indx, value, 2 * treeIndx + 2, !xor);
    if(xor) {
      segTree[treeIndx] = segTree[2 * treeIndx + 1] ^ segTree[2 * treeIndx + 2];
    } else {
      segTree[treeIndx] = segTree[2 * treeIndx + 1] | segTree[2 * treeIndx + 2];
    }
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int totalElements = (int) Math.pow(2, n);
    int[] nums = new int[totalElements];
    for(int i = 0; i < totalElements; i++) {
      nums[i] = scanner.nextInt();
    }
    buildTree(nums, totalElements, n);

    int queries = scanner.nextInt();
    while(queries-- > 0) {
      int indx = scanner.nextInt();
      int value = scanner.nextInt();
      update(indx, value, nums, n);
      System.out.println(segTree[0]);
    }
  }
}
