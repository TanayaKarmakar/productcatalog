package com.app.easy.design;


import java.util.Arrays;

class MyHashMap {
    int[] map;
    final int SIZE = 1000003;

    public MyHashMap() {
        this.map = new int[SIZE];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        this.map[key] = value;
    }

    public int get(int key) {
        return this.map[key];
    }

    public void remove(int key) {
        this.map[key] = -1;
    }
}

public class DesignAHashmapLeetcode706 {
    public static void main(String[] args) {

    }
}
