package com.app.medium.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/07/23
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
    preprocessResult(persons, times);
  }

  public int q(int t) {
    int indx = findGreatestIndxLessThant(t);
    VoteItem voteItem = voteItems[indx];

    Map<Integer, VoteValueItem> map = voteItem.resultSoFar;
    int winningCandidate = 0;
    int maxVote = Integer.MIN_VALUE;
    int maxTs = 0;

    for(Map.Entry<Integer, VoteValueItem> entry: map.entrySet()) {
      if(entry.getValue().freq > maxVote) {
        maxVote = entry.getValue().freq;
        winningCandidate = entry.getKey();
        maxTs = entry.getValue().recentTs;
      } else if(entry.getValue().freq == maxVote) {
        if(entry.getValue().recentTs > maxTs) {
          winningCandidate = entry.getKey();
          maxTs = entry.getValue().recentTs;
        }
      }
    }
    return winningCandidate;
  }

  private int findGreatestIndxLessThant(int t) {
    int n = this.voteItems.length;
    int start = 0;
    int end = n - 1;
    int finalAns = -1;
    while(start <= end) {
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

  private void preprocessResult(int[] persons, int[] times) {
    VoteValueItem voteValueItem = new VoteValueItem(1, times[0]);
    Map<Integer, VoteValueItem> resultSoFar = new HashMap<>();
    resultSoFar.put(persons[0], voteValueItem);
    VoteItem voteItem = new VoteItem(times[0], resultSoFar);
    voteItems[0] = voteItem;

    for(int i = 1; i < persons.length; i++) {
      Map<Integer, VoteValueItem> currentMap = new HashMap<>(resultSoFar);
      VoteValueItem newVoteValueItem = null;
      if(!currentMap.containsKey(persons[i])) {
        newVoteValueItem = new VoteValueItem(1, times[i]);
      } else {
        VoteValueItem existingVoteValueItem = currentMap.get(persons[i]);
        newVoteValueItem = new VoteValueItem(existingVoteValueItem.freq, existingVoteValueItem.recentTs);
        newVoteValueItem.freq = newVoteValueItem.freq + 1;
        newVoteValueItem.recentTs = times[i];
      }
      currentMap.put(persons[i], newVoteValueItem);
      voteItems[i] = new VoteItem(times[i], currentMap);
      resultSoFar = currentMap;
    }
  }
}

public class OnlineElectionLeetcode911 {
  public static void main(String[] args) {

  }
}
