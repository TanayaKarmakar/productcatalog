package com.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class GenerateParenthesisLeetcode22 {
    static class Item {
        String curr;
        int open;
        int close;

        public Item(String curr, int open, int close) {
            this.curr = curr;
            this.open = open;
            this.close = close;
        }
    }
    private static List<String> generateParenthesis(int n) {
        List<String> finalResult = new ArrayList<>();
        Queue<Item> q = new LinkedList<>();
        q.add(new Item("", 0, 0));
        while(!q.isEmpty()) {
            Item item = q.poll();
            if(item.close == item.open && item.open == n) {
                finalResult.add(item.curr);
                continue;
            }

            if(item.open > item.close) {
                Item item2 = new Item(item.curr + ")", item.open, item.close + 1);
                q.add(item2);
            }
            if(item.open < n){
                Item item1 = new Item( item.curr + "(", item.open + 1, item.close);
                q.add(item1);
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> finalResult = generateParenthesis(n);

        System.out.println(finalResult);
    }
}
