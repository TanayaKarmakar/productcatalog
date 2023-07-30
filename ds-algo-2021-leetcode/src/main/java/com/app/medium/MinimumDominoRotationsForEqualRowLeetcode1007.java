package com.app.medium;

/**
 * @author t0k02w6 on 08/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumDominoRotationsForEqualRowLeetcode1007 {
  static class MajorityItem {
    int count;
    int majIndx;

    public MajorityItem(int count, int majIndx) {
      this.count = count;
      this.majIndx = majIndx;
    }
  }

  private static MajorityItem findMajorityElement(int[] nums) {
    int count = 1;
    int majIndx = 0;

    int n = nums.length;
    for(int i = 1; i < n; i++) {
      if(nums[i] == nums[majIndx]) {
        count++;
      } else {
        count--;
        if(count == 0) {
          majIndx = i;
          count = 1;
        }
      }
    }

    count = 0;
    for(int i = 0; i < n; i++) {
      if(nums[i] == nums[majIndx]) {
        count++;
      }
    }

    if(count >= n/2)
      return new MajorityItem(count, majIndx);
    return new MajorityItem(0, -1);
  }

  private static int minDominoRotations(int[] tops, int[] bottoms) {
    MajorityItem topM = findMajorityElement(tops);
    MajorityItem bottomM = findMajorityElement(bottoms);

    int rotationCount = 0;
    int majorityCount = 0;

    if(topM.majIndx == -1 && bottomM.majIndx == -1)
      return -1;
    else if(topM.count > bottomM.count) {
      majorityCount = topM.count;
      for(int i = 0; i < bottoms.length; i++) {
        if(tops[i] != tops[topM.majIndx] && bottoms[i] == tops[topM.majIndx]) {
          rotationCount++;
        }
      }
    } else {
      majorityCount = bottomM.count;
      for(int i = 0; i < tops.length; i++) {
        if(bottoms[i] != bottoms[bottomM.majIndx] && tops[i] == bottoms[bottomM.majIndx]) {
          rotationCount++;
        }
      }
    }
    return majorityCount + rotationCount == tops.length ? rotationCount: -1;
  }

  public static void main(String[] args) {
    int[] tops = {2,1,2,4,2,2};
    int[] bottoms = {5,2,6,2,3,2};

    int ans = minDominoRotations(tops, bottoms);

    System.out.println(ans);
  }
}
