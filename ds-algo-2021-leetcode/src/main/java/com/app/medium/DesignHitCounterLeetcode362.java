package com.app.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */
class HitCounter {
    Queue<Integer> q;
    public HitCounter() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        int checkUpto = timestamp - 300;
        while(!q.isEmpty() && q.peek() <= checkUpto)
            q.poll();
        return q.size();
    }
}

public class DesignHitCounterLeetcode362 {
    public static void main(String[] args) {

    }
}
