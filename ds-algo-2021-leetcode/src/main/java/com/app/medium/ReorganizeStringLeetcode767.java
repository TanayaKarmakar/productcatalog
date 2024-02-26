package com.app.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeStringLeetcode767 {
    static class Item implements Comparable<Item> {
        char ch;
        int value;

        public Item(char ch, int value) {
            this.ch = ch;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            if(this.value == o.value)
                return this.ch - o.value;
            return o.value - this.value;
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
            pQ.add(new Item(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pQ.isEmpty()) {
            Item item = pQ.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != item.ch) {
                sb.append(item.ch);
                item.value = item.value - 1;
            } else {
                if(pQ.isEmpty())
                    return "";
                Item anotherItem = pQ.poll();
                sb.append(anotherItem.ch);
                anotherItem.value = anotherItem.value - 1;
                if(anotherItem.value != 0)
                    pQ.add(anotherItem);
            }
            if(item.value != 0)
                pQ.add(item);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
