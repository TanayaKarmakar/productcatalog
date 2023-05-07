package com.app.medium;

import java.util.TreeSet;

/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */
public class RankTeamsByVotesLeetcode1366 {
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
    int[][] rank = new int[26][n];
    int[] present = new int[26];

    for(int i = 0; i < votes.length; i++) {
      String currentVote = votes[i];
      for(int j = 0; j < currentVote.length(); j++) {
        int charIndx = currentVote.charAt(j) - 'A';
        rank[charIndx][j]++;
        present[charIndx] = 1;
      }
    }

    TreeSet<Team> teams = new TreeSet<>();
    for(int i = 0; i < 26; i++) {
      if(present[i] == 1) {
        int[] currentVotes = rank[i];
        char ch = (char)(i + 'A');
        teams.add(new Team(ch, currentVotes));
      }
    }

    StringBuilder sb = new StringBuilder();
    for(Team currentTeam: teams) {
      sb.append(currentTeam.ch);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String[] words = {"ABC","ACB","ABC","ACB","ACB"};
    String ans = rankTeams(words);

    System.out.println(ans);
  }
}
