package com.app.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIILeetcode212 {
    private static List<String> findWords(char[][] board, String[] words) {
        Set<String> containedWords = new HashSet<>();
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(String word: words) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(word.charAt(0) == board[i][j]) {
                        boolean isFound = findWord(board, visited, word, i, j, m, n, 0);
                        if(isFound) {
                            containedWords.add(word);
                        }
                        //clearMatrix(visited);
                    }
                }
            }
            clearMatrix(visited);
        }
        return new ArrayList<>(containedWords);
    }

    private static void clearMatrix(boolean[][] visited) {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean findWord(char[][] board, boolean[][] visited, String word, int i, int j, int m, int n, int indx) {
        if(indx >= word.length())
            return true;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(indx))
            return false;
        visited[i][j] = true;
        boolean isFound = findWord(board, visited, word, i - 1, j, m, n, indx + 1);
        isFound |= findWord(board, visited, word, i + 1, j, m, n, indx + 1);
        isFound |= findWord(board, visited, word, i, j - 1, m, n, indx + 1);
        isFound |= findWord(board, visited, word, i, j + 1, m, n, indx + 1);
        visited[i][j] = false;
        return isFound;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        List<String> containedWords = findWords(board, words);

        System.out.println(containedWords);
    }
}
