package com.app.onlinetest.airbnb;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/06/23
 * @project ds-algo-2021-leetcode
 */
public class FindMaximumInterest {
  static class Item {
    int startTime;
    int endTime;
    int interestLevel;

    public Item(int startTime, int endTime, int interestLevel) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.interestLevel = interestLevel;
    }
  }

  static int getMaximumLevelDP(int[][] travelInfo) {
    Arrays.sort(travelInfo, (t1, t2) -> t1[0] - t2[0]);
    Item[] dp = new Item[travelInfo.length];
    dp[0] = new Item(travelInfo[0][0], travelInfo[0][1], travelInfo[0][2]);

    int finalInterestLevel = dp[0].interestLevel;

    for(int i = 1; i < travelInfo.length; i++) {
      int endTime = travelInfo[i][1];
      int interestLevel = travelInfo[i][2];
      for(int j = 0; j < i; j++) {
        if(dp[j].endTime <= travelInfo[i][0]) {
          if(dp[j].interestLevel + travelInfo[i][2] > interestLevel) {
            interestLevel = dp[j].interestLevel + travelInfo[i][2];
          }
        }
      }
      dp[i] = new Item(0, endTime, interestLevel);
      finalInterestLevel = Integer.max(finalInterestLevel, dp[i].interestLevel);
    }
    return finalInterestLevel;
  }


  public static void main(String[] args) {
    int[][] travelInfo = {{0,2,4},{1,2,5},{2,4,5}};

    int ans = getMaximumLevelDP(travelInfo);

    System.out.println(ans);


    travelInfo = new int[][]{{2,5,5}, {3,6,6},{5,10,2},{4,10,8},{8,9,5},{13,14,1},{13,17,5},{14,16,8}};
    ans = getMaximumLevelDP(travelInfo);

    System.out.println(ans);

    travelInfo = new int[][]{{5,10,2}, {1,11,10},{2,5,5},{3,6,6}};

    ans = getMaximumLevelDP(travelInfo);

    System.out.println(ans);

    travelInfo = new int[][] {{9,11,3},{10,14,2},{12,15,2}};

    ans = getMaximumLevelDP(travelInfo);
    System.out.println(ans);
  }
}
