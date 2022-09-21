package com.app.medium;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class WordSearchLeetcode79 {
    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && !visited[i][j]) {
                    boolean isFound = isExist(board, visited, word, i, j, 0, m, n);
                    if(isFound)
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean isExist(char[][] board, boolean[][] visited, String word, int i, int j, int indx, int m, int n) {
        if(indx == word.length())
            return true;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(indx) || visited[i][j])
            return false;
        visited[i][j] = true;
        for(int k = 0; k < directions.length; k++) {
            int newRow = i + directions[k][0];
            int newCol = j + directions[k][1];
            if(isExist(board, visited, word, newRow, newCol, indx + 1, m, n))
                return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";

        boolean ans = exist(board, word);

        System.out.println(ans);
    }
}
