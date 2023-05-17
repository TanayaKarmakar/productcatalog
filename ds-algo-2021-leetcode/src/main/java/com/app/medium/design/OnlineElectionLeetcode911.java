package com.app.medium.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 17/05/23
 * @project ds-algo-2021-leetcode
 */
class TopVotedCandidate {

  static class VoteItem {
    int timestamp;
    Map<Integer, VoteValueItem> resultSoFar;

    public VoteItem(int timestamp, Map<Integer, VoteValueItem> resultSoFar) {
      this.timestamp = timestamp;
      this.resultSoFar = resultSoFar;
    }
  }

  static class VoteValueItem {
    int freq;
    int recentTs;

    public VoteValueItem(int freq, int recentTs) {
      this.freq = freq;
      this.recentTs = recentTs;
    }
  }

  private VoteItem[] voteItems;

  public TopVotedCandidate(int[] persons, int[] times) {
    int n = persons.length;
    this.voteItems = new VoteItem[n];
    preprocessResult(persons, times, n);
  }

  public int q(int t) {
    int indx = findGreatestIndexLessthanT(t);
    Map<Integer, VoteValueItem> map = voteItems[indx].resultSoFar;
    int maxVote = Integer.MIN_VALUE;
    int maxVoteCandidate = 0;
    int recentTs = 0;
    for(Map.Entry<Integer, VoteValueItem> entry: map.entrySet()) {
      if(entry.getValue().freq > maxVote) {
        maxVote = entry.getValue().freq;
        maxVoteCandidate = entry.getKey();
        recentTs = entry.getValue().recentTs;
      } else if(entry.getValue().freq == maxVote) {
        if(entry.getValue().recentTs > recentTs) {
          recentTs = entry.getValue().recentTs;
          maxVoteCandidate = entry.getKey();
        }
      }
    }
    return maxVoteCandidate;
  }

  private int findGreatestIndexLessthanT(int t) {
    int start = 0;
    int end = voteItems.length - 1;
    int finalAns = 0;
    while (start <= end) {
      int mid = (start + end) >> 1;
      if(voteItems[mid].timestamp == t)
        return mid;
      else if(voteItems[mid].timestamp > t) {
        end = mid - 1;
      } else {
        finalAns = mid;
        start = mid + 1;
      }
    }
    return finalAns;
  }

  private void preprocessResult(int[] persons, int[] times, int n) {
    Map<Integer, VoteValueItem> map = new HashMap<>();
    map.put(persons[0], new VoteValueItem(1, times[0]));
    VoteItem voteItem = new VoteItem(times[0], map);
    voteItems[0] = voteItem;

    for(int i = 1; i < n; i++) {
      Map<Integer, VoteValueItem> currentMap = new HashMap<>(map);
      VoteValueItem voteValueItem = null;
      if(!currentMap.containsKey(persons[i])) {
        voteValueItem = new VoteValueItem(1, times[i]);
      } else {
        voteValueItem = new VoteValueItem(currentMap.get(persons[i]).freq, currentMap.get(persons[i]).recentTs);
        voteValueItem.freq = voteValueItem.freq + 1;
        voteValueItem.recentTs = times[i];
      }
      currentMap.put(persons[i], voteValueItem);

      voteItem = new VoteItem(times[i], currentMap);
      voteItems[i] = voteItem;
      map = new HashMap<>(currentMap);
    }
  }
}

public class OnlineElectionLeetcode911 {
  public static void main(String[] args) {
    TopVotedCandidate tc = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
        new int[]{0, 5, 10, 15, 20, 25, 30});

    System.out.println(tc.q(3));
    System.out.println(tc.q(12));
    System.out.println(tc.q(25));
    System.out.println(tc.q(15));
    System.out.println(tc.q(24));
    System.out.println(tc.q(8));
  }
}
