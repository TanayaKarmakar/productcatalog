package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class MinimumKnightMovesLeetcode1197 {
    private static final int[][] directions = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row && col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    private static int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<Cell> q = new LinkedList<>();
        int count = 0;
        Set<Cell> visited = new HashSet<>();
        Cell start = new Cell(0, 0);
        q.add(start);
        visited.add(start);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Cell node = q.poll();
                if(node.row == x && node.col == y)
                    return count;
                for(int j = 0; j < directions.length; j++) {
                    int newRow = node.row + directions[j][0];
                    int newCol = node.col + directions[j][1];
                    Cell newCell = new Cell(newRow, newCol);
                    if(newRow < 0 || newRow > 300 || newCol < 0 || newCol > 300
                    || visited.contains(newCell))
                        continue;


                    visited.add(newCell);
                    q.add(newCell);

                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = minKnightMoves(5, 5);
        System.out.println(ans);
    }
}
