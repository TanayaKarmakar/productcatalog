package com.app.medium.atlassian;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class RankTeamsByVotesLeetcode1366 {
    static class Team implements Comparable<Team> {
        char ch;
        int[] votes;

        public Team(char ch, int[] votes) {
            this.ch = ch;
            this.votes = votes;
        }

        @Override
        public int compareTo(@NotNull Team o) {
            int n = votes.length;
            for(int i = 0; i < n; i++) {
                if(this.votes[i] != o.votes[i])
                    return o.votes[i] - this.votes[i];
            }
            return this.ch - o.ch;
        }
    }

    private static String rankTeams(String[] votes) {
        Map<Character, int[]> candidateWiseVote = new HashMap<>();
        for(String vote: votes) {
            for(int charIndx = 0; charIndx < vote.length(); charIndx++) {
                char currentChar = vote.charAt(charIndx);
                if(!candidateWiseVote.containsKey(currentChar))
                    candidateWiseVote.put(currentChar, new int[vote.length()]);
                candidateWiseVote.get(currentChar)[charIndx]++;
            }
        }

        TreeSet<Team> treeSet = new TreeSet<>();
        for(Map.Entry<Character, int[]> entry: candidateWiseVote.entrySet()) {
            treeSet.add(new Team(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        for(Team team: treeSet) {
            sb.append(team.ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
