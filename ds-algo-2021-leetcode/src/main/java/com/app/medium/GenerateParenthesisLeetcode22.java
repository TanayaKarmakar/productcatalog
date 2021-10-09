package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 07/10/21
 * @project ds-algo-2021
 */
class ParenItem {
    String strSoFar;
    int open;
    int close;

    public ParenItem(String strSoFar, int open, int close) {
        this.strSoFar = strSoFar;
        this.open = open;
        this.close = close;
    }

    public String getStrSoFar() {
        return strSoFar;
    }

    public void setStrSoFar(String strSoFar) {
        this.strSoFar = strSoFar;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }
}


public class GenerateParenthesisLeetcode22 {
    private static List<String> generateParenthesis(int n) {
        Queue<ParenItem> q = new LinkedList<>();
        q.add(new ParenItem("", 0, 0));

        Set<String> set = new HashSet<>();
        while(!q.isEmpty()) {
            ParenItem parenItem = q.poll();
            if(parenItem.open == parenItem.close && parenItem.open == n) {
                set.add(parenItem.strSoFar);
                continue;
            }

            String strSofar = parenItem.strSoFar;
            if(parenItem.open < n) {
                q.add(new ParenItem(strSofar + "(", parenItem.open + 1, parenItem.close));
            }
            if(parenItem.open > parenItem.close) {
                q.add(new ParenItem(strSofar + ")", parenItem.open, parenItem.close + 1));
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
