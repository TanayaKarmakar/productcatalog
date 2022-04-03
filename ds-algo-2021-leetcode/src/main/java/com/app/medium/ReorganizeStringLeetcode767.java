package com.app.medium;

import com.app.common.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
class ValueComparator6 implements Comparator<Pair<Character, Integer>> {

    @Override
    public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
        if(o1.second == o2.second)
            return o1.first.compareTo(o2.first);
        return o2.second - o1.second;
    }
}

public class ReorganizeStringLeetcode767 {
    private static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> pQ = new PriorityQueue<>(new ValueComparator6());
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pQ.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pQ.isEmpty()) {
            Pair<Character, Integer> pair = pQ.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != pair.first) {
                sb.append(pair.first);
                pair.second = pair.second - 1;
                if(pair.second > 0)
                    pQ.add(pair);
            } else {
                if(pQ.isEmpty())
                    return "";
                Pair<Character, Integer> pair1 = pQ.poll();
                sb.append(pair1.first);
                sb.append(pair.first);
                pair1.second = pair1.second - 1;
                if(pair1.second > 0)
                    pQ.add(pair1);
                pair.second = pair.second - 1;
                if(pair.second > 0)
                    pQ.add(pair);
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
