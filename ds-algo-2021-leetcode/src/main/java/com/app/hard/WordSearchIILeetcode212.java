package com.app.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchIILeetcode212 {
    private static List<String> findWords(char[][] board, String[] words) {
        List<String> containedWords = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(String word: words) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == word.charAt(0))   {
                        if(canForm(word, board, visited, i, j, m, n, 0)) {
                            containedWords.add(word);
                        }
                    }
                }
            }
            clearMatrix(visited);
        }
        return containedWords;
    }

    private static boolean canForm(String word, char[][] board, boolean[][] visited, int i, int j, int m, int n, int indx) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(indx))
            return false;
        visited[i][j] = true;
        boolean isFound = canForm(word, board, visited, i + 1, j, m, n, indx + 1);
        isFound |= canForm(word, board, visited, i - 1, j, m, n, indx + 1);
        isFound |= canForm(word, board, visited, i, j + 1, m, n, indx + 1);
        isFound |= canForm(word, board, visited, i, j - 1, m, n, indx + 1);
        visited[i][j] = false;
        return isFound;
    }

    private static void clearMatrix(boolean[][] visited) {
        for(int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }


    public static void main(String[] args) {

    }
}
