package com.app.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 14/02/23
 * @project ds-algo-2021-leetcode
 */
class TopVotedCandidate {
  Map<Integer, List<Integer>> map;
  int[] times;

  public TopVotedCandidate(int[] persons, int[] times) {
    map = new HashMap<>();
    for(int i = 0; i < persons.length; i++) {
      if(!map.containsKey(persons[i]))
        map.put(persons[i], new ArrayList<>());
      map.get(persons[i]).add(times[i]);
    }
    this.times = times;
  }

  public int q(int t) {
    //int num = findNumberLesser(t);
    int[] persons = new int[map.size()];
    int[] recent = new int[map.size()];
    int maxCount = 0;
    for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
      List<Integer> values = entry.getValue();
      int ceiling = findIndexForLesser(t, values);
      persons[entry.getKey()] += (ceiling + 1);
      maxCount = Integer.max(maxCount, persons[entry.getKey()]);
      recent[entry.getKey()] = ceiling == -1 ? 0:values.get(ceiling);
    }


    List<Integer> personIndices = new ArrayList<>();
    for(int i = 0; i < persons.length; i++) {
      if(persons[i] == maxCount) {
        personIndices.add(i);
      }
    }

    if(personIndices.size() == 1)
      return personIndices.get(0);

    int mostRecent = 0;
    int personIndex = -1;
    for(Integer el: personIndices) {
      if(recent[el] > mostRecent) {
        mostRecent = recent[el];
        personIndex = el;
      }
    }
    return personIndex;
  }

  private int findIndexForLesser(int t, List<Integer> values) {
    int start = 0;
    int end = values.size() - 1;
    int finalAns = -1;
    while(start <= end) {
      int mid = (start + end) >> 1;
      if(values.get(mid) == t)
        return mid;
      else if(values.get(mid) > t)
        end = mid - 1;
      else {
        finalAns= mid;
        start = mid + 1;
      }
    }
    return finalAns;
  }
}

public class OnlineElectionLeetcode911 {
  public static void main(String[] args) {
    TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
        new int[]{0, 5, 10, 15, 20, 25, 30});
    System.out.println(topVotedCandidate.q(3)); // return 0, At time 3, the votes are [0], and 0 is leading.
    System.out.println(topVotedCandidate.q(12)); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
    System.out.println(topVotedCandidate.q(25)); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
    System.out.println(topVotedCandidate.q(15)); // return 0
    System.out.println(topVotedCandidate.q(24)); // return 0
    System.out.println(topVotedCandidate.q(8)); // return 1
  }
}
