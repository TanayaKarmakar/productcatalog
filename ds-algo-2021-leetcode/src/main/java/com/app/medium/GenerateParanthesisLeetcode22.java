package com.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParanthesisLeetcode22 {
    static class Item {
        String charSoFar;
        int open;
        int close;

        public Item(String charSoFar, int open, int close) {
            this.charSoFar = charSoFar;
            this.open = open;
            this.close = close;
        }
    }

    private static List<String> generateParenthesis(int n) {
        Queue<Item> q = new LinkedList<>();
        List<String> result = new ArrayList<>();

        q.add(new Item("", 0, 0));

        while(!q.isEmpty()) {
            Item item = q.poll();
            if(item.open == item.close && item.open == n) {
                result.add(item.charSoFar);
                continue;
            }
            if(item.open < n) {
                Item newItem = new Item(item.charSoFar + "(", item.open + 1, item.close);
                q.add(newItem);
            }


            if(item.open > item.close) {
                Item newItem1 = new Item(item.charSoFar + ")",  item.open, item.close + 1 );
                q.add(newItem1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
