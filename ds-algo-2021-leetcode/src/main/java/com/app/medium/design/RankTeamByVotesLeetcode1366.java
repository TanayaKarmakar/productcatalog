package com.app.medium.design;

import java.util.TreeSet;

/**
 * @author t0k02w6 on 13/06/23
 * @project ds-algo-2021-leetcode
 */
public class RankTeamByVotesLeetcode1366 {
  static class Team implements Comparable<Team> {
    private char ch;
    private int[] votes;

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
    int n = votes[0].length();
    int[][] ranks = new int[26][n];
    int[] present = new int[26];

    for(String vote: votes) {
      for(int i = 0; i < vote.length(); i++) {
        int charIndx = vote.charAt(i) - 'A';
        ranks[charIndx][i]++;
        present[charIndx] = 1;
      }
    }

    TreeSet<Team> teams = new TreeSet<>();
    for(int i = 0; i < 26; i++) {
      if(present[i] == 1) {
        char ch = (char)(i + 'A');
        int[] teamVotes = ranks[i];
        teams.add(new Team(ch, teamVotes));
      }
    }

    StringBuilder sb = new StringBuilder();
    for(Team team: teams) {
      sb.append(team.ch);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
    String result = rankTeams(votes);

    System.out.println(result);
  }
}
