package com.app.medium;

import com.app.common.Triplet;

import java.util.*;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */

public class GenerateParenthesisLeetcode22 {
    private static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();

        Triplet<String, Integer, Integer> triplet = new Triplet<>("(", 1, 0);
        Queue<Triplet<String, Integer, Integer>> queue = new LinkedList<>();
        queue.add(triplet);

        while(!queue.isEmpty()) {
            Triplet<String, Integer, Integer> remItem = queue.poll();
            if(remItem.getSecond() == remItem.getThird() && remItem.getSecond() == n) {
                System.out.println(remItem.getFirst());
                set.add(remItem.getFirst());
                continue;
            }
            if(remItem.getSecond() == n) {
                Triplet<String, Integer, Integer> newItem = new Triplet<>(remItem.getFirst() + ")",
                        remItem.getSecond(), remItem.getThird() + 1);
                queue.add(newItem);
            } else {
                if(remItem.getSecond() == remItem.getThird()) {
                    Triplet<String, Integer, Integer> newItem = new Triplet<>(remItem.getFirst() + "(",
                            remItem.getSecond() + 1, remItem.getThird());
                    queue.add(newItem);
                } else {
                    Triplet<String, Integer, Integer> newItem1 = new Triplet<>(remItem.getFirst() + "(",
                            remItem.getSecond() + 1, remItem.getThird());
                    Triplet<String, Integer, Integer> newItem2 = new Triplet<>(remItem.getFirst() + ")",
                            remItem.getSecond(), remItem.getThird() + 1);
                    queue.add(newItem1);
                    queue.add(newItem2);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int n = 3;

        List<String> result = generateParenthesis(n);

        System.out.println(result);
    }
}
