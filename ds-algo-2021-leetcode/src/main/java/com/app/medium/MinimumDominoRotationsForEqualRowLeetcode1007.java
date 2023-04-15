package com.app.medium;

/**
 * @author t0k02w6 on 15/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumDominoRotationsForEqualRowLeetcode1007 {
  static class MajorityItem {
    int indx;
    int count;

    public MajorityItem(int indx, int count) {
      this.indx = indx;
      this.count = count;
    }
  }

  private static MajorityItem findMajority(int[] nums) {
    int count = 1;
    int majIndx = 0;
    for(int i = 1; i < nums.length; i++) {
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
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == nums[majIndx]) {
        count++;
      }
    }

    if(count >= nums.length / 2) {
      return new MajorityItem(majIndx, count);
    }
    return new MajorityItem(-1, -1);
  }

  private static int findRotationCount(int[] majority, int[] nonMajority, MajorityItem majorityItem) {
    int count = 0;

    for(int i = 0; i < majority.length; i++) {
      if(majority[i] != majority[majorityItem.indx] && nonMajority[i] != majority[majorityItem.indx])
        continue;
      else if(majority[i] != majority[majorityItem.indx] && nonMajority[i] == majority[majorityItem.indx]) {
        count++;
      }
    }

    return count;
  }

  private static int minDominoRotations(int[] tops, int[] bottoms) {
      MajorityItem topItem = findMajority(tops);
      MajorityItem bottomItem = findMajority(bottoms);

      int count = 0;
      int majorityCount = 0;
      if(topItem.indx == -1 && bottomItem.indx == -1)
        return -1;
      else if(topItem.count > bottomItem.count) {
        count = findRotationCount(tops, bottoms, topItem);
        majorityCount = topItem.count;
      } else  {
        count = findRotationCount(bottoms, tops, bottomItem);
        majorityCount = bottomItem.count;
      }
      if(majorityCount + count == tops.length)
        return count;
      return -1;
  }


  public static void main(String[] args) {

  }
}
