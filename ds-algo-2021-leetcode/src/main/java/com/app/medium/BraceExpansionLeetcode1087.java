package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class BraceExpansionLeetcode1087 {
    private static String[] expand(String s) {
        if(s.indexOf('{') == -1)
            return new String[]{s};

        List<List<String>> tokens = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '}') {
                List<String> exprList = new ArrayList<>();
                while(!stack.isEmpty() && !stack.peek().equals("{")) {
                    exprList.add(0,stack.pop());
                }
                stack.pop();

                if(!stack.isEmpty()) {
                    List<String> txtList = new ArrayList<>();
                    while(!stack.isEmpty()) {
                        txtList.add(0,stack.pop());
                    }
                    tokens.add(txtList);
                }
                tokens.add(exprList);
            } else {
                if(s.charAt(i) != ',')
                    stack.push(s.charAt(i) + "");
            }
        }

        if(!stack.isEmpty()) {
            List<String> txtList = new ArrayList<>();
            while(!stack.isEmpty()) {
                txtList.add(0, stack.pop());
            }
            tokens.add(txtList);
        }

        Queue<String> q = new LinkedList<>();
        for(List<String> token: tokens) {
            if(q.isEmpty()) {
                q.addAll(token);
            } else {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    String remItem = q.poll();
                    for(String el: token) {
                        q.add(remItem + el);
                    }
                }
            }
        }

        String[] finalResult = new String[q.size()];
        int i = 0;
        while(!q.isEmpty()) {
            finalResult[i++] = q.poll();
        }
        Arrays.sort(finalResult);
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] ans = expand(str);

        System.out.println(Arrays.toString(ans));

        scanner.close();
    }
}
