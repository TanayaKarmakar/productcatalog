package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 29/03/22
 * @project ds-algo-2021
 */
class ValueComparator3 implements Comparator<Pair<String, Integer>> {

    @Override
    public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
        if(o1.second == o2.second)
            return o1.first.compareTo(o2.first);
        return o1.second - o2.second;
    }
}

class ValueComparator4 implements Comparator<Pair<String, Integer>> {

    @Override
    public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
        if(o1.second == o2.second)
            return o1.first.compareTo(o2.first);
        return o2.second - o1.second;
    }
}

public class TopKFrequentWordsLeetcode692 {
    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Pair<Integer, Boolean>> map = new HashMap<>();
        for(String word: words) {
            Pair<Integer, Boolean> valuePair = null;
            if(!map.containsKey(word)) {
                valuePair = new Pair<>(1, false);
                map.put(word, valuePair);
            } else {
                valuePair = map.get(word);
                valuePair.first = valuePair.first + 1;
                map.put(word, valuePair);
            }
        }

        PriorityQueue<Pair<String, Integer>> pQ = new PriorityQueue<>(new ValueComparator3());
        int i = 0;
        for(Map.Entry<String, Pair<Integer, Boolean>> entry: map.entrySet()) {
            if(i == k)
                break;
            pQ.add(new Pair<>(entry.getKey(), entry.getValue().first));
            entry.getValue().second = true;
            i++;
        }

        for(Map.Entry<String, Pair<Integer, Boolean>> entry: map.entrySet()) {
            if(entry.getValue().second)
                continue;
            if(pQ.peek().second < entry.getValue().first) {
                pQ.poll();
                pQ.add(new Pair<>(entry.getKey(), entry.getValue().first));
            }
        }

        PriorityQueue<Pair<String, Integer>> pQ1 = new PriorityQueue<>(new ValueComparator4());
        while(!pQ.isEmpty()) {
            pQ1.add(pQ.poll());
        }

        List<String> result = new ArrayList<>();
        while(!pQ1.isEmpty()) {
            Pair<String, Integer> pair = pQ1.poll();
            result.add(pair.first);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> result = topKFrequent(words, k);

        System.out.println(result);
    }
}
