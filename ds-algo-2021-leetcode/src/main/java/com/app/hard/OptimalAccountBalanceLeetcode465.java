package com.app.hard;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalanceLeetcode465 {
    private static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> debtMap = new HashMap<>();

        for(int i = 0; i < transactions.length; i++) {
            int from = transactions[i][0];
            int to = transactions[i][1];
            int amount = transactions[i][2];
            debtMap.put(from, debtMap.getOrDefault(from, 0) - amount);
            debtMap.put(to, debtMap.getOrDefault(to, 0) + amount);
        }

        int n = debtMap.size();
        int[] balance = new int[n];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: debtMap.entrySet()) {
            balance[i++] = entry.getValue();
        }

        return minTransfersRec(balance, 0);
    }

    private static int minTransfersRec(int[] balance, int indx) {
        if(indx == balance.length)
            return 0;
        if(balance[indx] == 0)
            return minTransfersRec(balance, indx + 1);

        int res = Integer.MAX_VALUE;
        int currDebt = balance[indx];

        for(int i = indx + 1; i < balance.length; i++) {
            if(currDebt * balance[i] < 0) {
                balance[i] += currDebt;
                res = Integer.min(res, minTransfersRec(balance, indx + 1) + 1);
                balance[i] -= currDebt;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] transactions = {{0,1,10},{2,0,5}};
        int ans = minTransfers(transactions);

        System.out.println(ans);
    }
}
