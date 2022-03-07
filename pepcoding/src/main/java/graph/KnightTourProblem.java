package graph;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/03/22
 * @project ds-algo-2021
 */
public class KnightTourProblem {
    static int[][] moves = {{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};

    private static void knightsTour(int[][] board, boolean[][] visited, int r, int c, int move) {
        if(r < 0 || r >= board.length || c < 0 || c >= board.length || visited[r][c])
            return;
        if(move == board.length * board.length) {
            //display board
            displayBoard(board);
            return;
        }
        visited[r][c] = true;
        board[r][c] = move;
        for(int i = 0; i < moves.length; i++) {
            int newRow = moves[i][0];
            int newCol = moves[i][1];
            knightsTour(board, visited, newRow, newCol, move + 1);
        }
    }

    private static void solve(int n, int r, int c) {
        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        knightsTour(board, visited, r, c, 1);
    }

    private static void displayBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        solve(n, r, c);

        scanner.close();
    }
}
