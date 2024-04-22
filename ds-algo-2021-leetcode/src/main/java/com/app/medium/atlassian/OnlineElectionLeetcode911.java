package com.app.medium.atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TopVotedCandidate {
    private TreeMap<Integer, Integer> timeWiseLeaderMap;
    private Map<Integer, Integer> personWiseVoteCountMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        timeWiseLeaderMap = new TreeMap<>();
        personWiseVoteCountMap = new HashMap<>();
        int n = persons.length;

        int lead = -1;
        for(int i = 0; i < n; i++) {
            personWiseVoteCountMap.put(persons[i],
                    personWiseVoteCountMap.getOrDefault(persons[i], 0) + 1);
            if(lead == -1 || personWiseVoteCountMap.get(persons[i]) >= personWiseVoteCountMap.get(lead)) {
                lead = persons[i];
            }
            timeWiseLeaderMap.put(times[i], lead);
        }
    }

    public int q(int t) {
        int key = timeWiseLeaderMap.floorKey(t);
        return timeWiseLeaderMap.get(key);
    }
}


public class OnlineElectionLeetcode911 {
    public static void main(String[] args) {

    }
}
