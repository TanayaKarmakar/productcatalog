package com.app.medium.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
        public int compareTo(Team o) {
            for(int i = 0; i < votes.length; i++) {
                if(this.votes[i] != o.votes[i])
                    return o.votes[i] - this.votes[i];
            }
            return this.ch - o.ch;
        }
    }

    private static String rankTeams(String[] votes) {
        int n = votes.length;
        TreeMap<Character, int[]> map = new TreeMap<>();

        for(String vote: votes) {
            for(int i = 0; i < vote.length(); i++) {
                char ch = vote.charAt(i);
                if(!map.containsKey(ch))
                    map.put(ch, new int[vote.length()]);
                map.get(ch)[i]++;
            }
        }

        TreeSet<Team> teams = new TreeSet<>();
        for(Map.Entry<Character, int[]> entry: map.entrySet()) {
            teams.add(new Team(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        for(Team team: teams) {
            sb.append(team.ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        String ans = rankTeams(votes);

        System.out.println(ans);
    }
}
