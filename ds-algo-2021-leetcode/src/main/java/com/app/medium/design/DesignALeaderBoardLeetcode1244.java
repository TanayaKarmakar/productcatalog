package com.app.medium.design;

import java.util.*;


class Leaderboard {
    static class ScoreItem implements Comparable<ScoreItem> {
        int playerId;
        int score;

        public ScoreItem(int playerId, int score) {
            this.playerId = playerId;
            this.score = score;
        }

        @Override
        public int compareTo(ScoreItem o) {
            return o.score - this.score;
        }
    }

    Map<Integer, ScoreItem> map;
    PriorityQueue<ScoreItem> priorityQueue;

    public Leaderboard() {
        map = new HashMap<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void addScore(int playerId, int score) {
        if(!map.containsKey(playerId)) {
            ScoreItem scoreItem = new ScoreItem(playerId, score);
            map.put(playerId, scoreItem);
            priorityQueue.add(scoreItem);
        } else {
            ScoreItem scoreItem = map.get(playerId);
            priorityQueue.remove(scoreItem);
            scoreItem.score = scoreItem.score + score;
            map.put(playerId, scoreItem);
            priorityQueue.add(scoreItem);
        }
    }

    public int top(int K) {
        int sum = 0;
        List<ScoreItem> topKItems = new ArrayList<>();
        while(!priorityQueue.isEmpty() && K-- > 0) {
            ScoreItem scoreItem = priorityQueue.poll();
            sum += scoreItem.score;
            topKItems.add(scoreItem);
        }

        priorityQueue.addAll(topKItems);
        return sum;
    }

    public void reset(int playerId) {
        ScoreItem scoreItem = map.get(playerId);
        priorityQueue.remove(scoreItem);
        map.remove(playerId);
    }
}
public class DesignALeaderBoardLeetcode1244 {
    public static void main(String[] args) {

    }
}
