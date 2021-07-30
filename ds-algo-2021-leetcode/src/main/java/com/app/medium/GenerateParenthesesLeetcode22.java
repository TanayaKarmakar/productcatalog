package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 29/07/21
 * @project ds-algo-2021
 */
public class GenerateParenthesesLeetcode22 {

    static class Parentheis {
        String item;
        int open;
        int close;

        public Parentheis(String item, int open, int close) {
            this.item = item;
            this.open = open;
            this.close = close;
        }
    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        Queue<Parentheis> q = new LinkedList<>();
        q.add(new Parentheis("", 0, 0));

        while(!q.isEmpty()) {
            Parentheis p = q.poll();
            if(p.open == n && p.close == n) {
                result.add(p.item);
                continue;
            }

            if(p.open < n)
                q.add(new Parentheis(p.item + "(", p.open + 1, p.close));
            if(p.open > p.close)
                q.add(new Parentheis(p.item + ")", p.open, p.close + 1));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> ans = generateParenthesis(n);
        System.out.println(ans);

        scanner.close();
    }
}
