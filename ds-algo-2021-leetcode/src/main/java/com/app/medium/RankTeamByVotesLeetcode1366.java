package com.app.medium;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class RankTeamByVotesLeetcode1366 {
    static class Team implements Comparable<Team> {
        char ch;
        int[] votes;

        public Team(char ch, int[] votes) {
            this.ch = ch;
            this.votes = votes;
        }

        @Override
        public int compareTo(Team o) {
            int[] votes = this.votes;
            for(int i = 0; i < votes.length; i++) {
                if(votes[i] != o.votes[i])
                    return o.votes[i] - votes[i];
            }
            return this.ch - o.ch;
        }
    }

    private static String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] rank = new int[26][n];
        int[] present = new int[26];

        for(String vote: votes) {
            for(int i = 0; i < vote.length(); i++) {
                int charIndx = vote.charAt(i) - 'A';
                rank[charIndx][i]++;
                present[charIndx] = 1;
            }
        }

        TreeSet<Team> treeSet = new TreeSet<Team>();
        for(int i = 0; i < 26; i++) {
            if(present[i] == 1) {
                int[] currentVotes = rank[i];
                char ch = (char)(i + 'A');
                treeSet.add(new Team(ch, currentVotes));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Team team: treeSet) {
            sb.append(team.ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"ABC","ACB","ABC","ACB","ACB"};
        String ans = rankTeams(strs);

        System.out.println(ans);
    }
}
