package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
class MyHashMap {
    private final int MAX = 1000010;
    private int[] map;

    public MyHashMap() {
        map = new int[MAX];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

public class DesignHashMapLeetcode706 {
}
