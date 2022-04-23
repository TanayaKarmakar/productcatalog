package com.app.medium;

import com.app.common.Pair;
import com.app.easy.PivotIndexLeetcode724;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class SurroundedRegionsLeetcode130 {
    private static void solve(char[][] board) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            Pair<Integer, Integer> pair = new Pair<>(i, 0);
            pairs.add(pair);

            pair = new Pair<>(i, n - 1);
            pairs.add(pair);
        }

        for(int i = 0; i < n; i++) {
            Pair<Integer, Integer> pair = new Pair<>(0, i);
            pairs.add(pair);

            pair = new Pair<>(m - 1, i);
            pairs.add(pair);
        }

        for(Pair<Integer, Integer> pair: pairs) {
            dfs(board, pair.first, pair.second, m, n);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'E')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            return;
        board[i][j] = 'E';
        dfs(board, i - 1, j, m, n);
        dfs(board, i + 1, j, m, n);
        dfs(board, i, j - 1, m, n);
        dfs(board, i, j + 1, m, n);
    }

    public static void main(String[] args) {

    }
}
