package com.app.medium;

public class WordSearchLeetcode79 {
    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(isExist(board, visited, word, i, j, m, n, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean isExist(char[][] board, boolean[][] visited, String word, int i, int j, int m, int n, int indx) {
        if(indx == word.length())
            return true;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(indx))
            return false;
        visited[i][j] = true;
        boolean isFound = isExist(board, visited, word, i + 1, j, m, n, indx + 1);
        isFound |= isExist(board, visited, word, i - 1, j, m, n, indx + 1);
        isFound |= isExist(board, visited, word, i, j + 1, m, n, indx + 1);
        isFound |= isExist(board, visited, word, i, j - 1, m, n, indx + 1);
        visited[i][j] = false;
        return isFound;
    }

    public static void main(String[] args) {

    }
}
