package com.app.medium;


import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author t0k02w6 on 13/09/22
 * @project ds-algo-2021-leetcode
 */
public class RankTeamsByVotesLeetcode1366 {
    static class Node implements Comparable<Node>{
        char ch;
        int[] votes;

        public Node(char ch, int[] votes) {
            this.ch = ch;
            this.votes = votes;
        }

        @Override
        public int compareTo(Node o) {
            for(int i = 0; i < votes.length; i++) {
                if(votes[i] != o.votes[i])
                    return o.votes[i] - votes[i];
            }
            return this.ch - o.ch;
        }
    }

    private static String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] rank = new int[26][len];
        int[] present = new int[26];

        for(String vote: votes) {
            for(int i = 0; i < vote.length(); i++) {
                int pos = vote.charAt(i) - 'A';
                rank[pos][i]++;
                present[pos] = 1;
            }
        }

        TreeSet<Node> treeSet = new TreeSet<>();
        for(int i = 0; i < 26; i++) {
            if(present[i] == 1) {
                int[] currentVotes = rank[i];
                char ch = (char)(i + 'A');
                Node node = new Node(ch, currentVotes);
                treeSet.add(node);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Node currentNode: treeSet) {
            sb.append(currentNode.ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] votes = {"WXYZ", "XYZW"};
        System.out.println(rankTeams(votes));
    }
}
