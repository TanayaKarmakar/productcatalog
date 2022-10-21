package com.app.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class ReorganizeStringLeetcode767 {
    static class Item implements Comparable<Item> {
        char ch;
        int freq;

        public Item(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }


        @Override
        public int compareTo(Item o) {
            return o.freq - this.freq;
        }
    }

    private static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Item> pQ = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            Item item = new Item(entry.getKey(), entry.getValue());
            pQ.add(item);
        }

        StringBuilder sb = new StringBuilder();
        while(!pQ.isEmpty()) {
            Item item = pQ.poll();
            if(sb.toString().isEmpty() || sb.charAt(sb.length() - 1) != item.ch) {
                sb.append(item.ch);
                item.freq = item.freq - 1;
                if(item.freq > 0)
                    pQ.add(item);
            } else {
                if(pQ.isEmpty())
                    return "";
                Item anotherItem = pQ.poll();
                sb.append(anotherItem.ch);
                anotherItem.freq = anotherItem.freq - 1;
                if(anotherItem.freq > 0)
                    pQ.add(anotherItem);
                pQ.add(item);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aab";

        String ans = reorganizeString(str);

        System.out.println(ans);
    }
}
