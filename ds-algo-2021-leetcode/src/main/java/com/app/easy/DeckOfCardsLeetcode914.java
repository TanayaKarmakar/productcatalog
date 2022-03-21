package com.app.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class DeckOfCardsLeetcode914 {
    private static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            set.add(entry.getValue());
        }

        return set.size() == 1;
    }

    public static void main(String[] args) {

    }
}
