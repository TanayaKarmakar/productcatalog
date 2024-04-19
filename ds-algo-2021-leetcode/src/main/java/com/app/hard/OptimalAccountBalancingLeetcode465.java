package com.app.hard;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancingLeetcode465 {
    private static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        for(int i = 0; i < transactions.length; i++) {
            int from = transactions[i][0];
            int to = transactions[i][1];
            int amt = transactions[i][2];
            balanceMap.put(from, balanceMap.getOrDefault(from, 0) - amt);
            balanceMap.put(to, balanceMap.getOrDefault(to, 0) + amt);
        }

        int[] balaces = new int[balanceMap.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: balanceMap.entrySet()) {
            balaces[i++] = entry.getValue();
        }

        return minTransfersRec(balaces, 0);
    }

    private static int minTransfersRec(int[] balances, int indx) {
        if(indx >= balances.length)
            return 0;
        if(balances[indx] == 0)
            return minTransfersRec(balances, indx + 1);

        int currDebt = balances[indx];
        int res = Integer.MAX_VALUE;
        for(int i = indx + 1; i < balances.length; i++) {
            if(balances[i] * currDebt < 0) {
                balances[i] += currDebt;
                res = Integer.min(res, minTransfersRec(balances, indx + 1) + 1);
                balances[i] -= currDebt;
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
