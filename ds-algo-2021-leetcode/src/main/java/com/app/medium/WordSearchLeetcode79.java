package com.app.medium;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
public class WordSearchLeetcode79 {
    private static boolean wordSearch(char[][] board, boolean[][] visited, String word, int currentIndx, int i, int j) {
        if(currentIndx == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(currentIndx))
            return false;

        visited[i][j] = true;
        boolean top = wordSearch(board, visited, word, currentIndx + 1, i - 1, j);
        boolean bottom = wordSearch(board, visited, word, currentIndx + 1, i + 1, j);
        boolean left = wordSearch(board, visited, word, currentIndx + 1, i, j - 1);
        boolean right = wordSearch(board, visited, word, currentIndx + 1, i, j + 1);
        boolean isFound = (top || bottom || left || right);
        if(isFound)
            return true;
        visited[i][j] = false;
        return false;
    }

    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        int startIndx = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] == word.charAt(startIndx)) {
                    boolean found = wordSearch(board, visited, word, startIndx, i, j);
                    if(found)
                        return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";

        boolean ans = exist(board, word);

        System.out.println(ans);
    }
}
