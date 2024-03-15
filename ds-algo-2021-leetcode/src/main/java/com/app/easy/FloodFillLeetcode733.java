package com.app.easy;

public class FloodFillLeetcode733 {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private static int startColor = 0;

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];

        if(image[sr][sc] == color)
            return image;

        startColor = image[sr][sc];
        dfs(image, visited, m, n, sr, sc, color);
        return image;
    }

    private static void dfs(int[][] image, boolean[][] visited, int m, int n, int sr, int sc, int color) {
        if(sr < 0 || sr >= m || sc < 0 || sc >= n || visited[sr][sc] || image[sr][sc] != startColor)
            return;
        visited[sr][sc] = true;
        image[sr][sc] = color;
        for(int i = 0; i < directions.length; i++) {
            int newRow = sr + directions[i][0];
            int newCol = sc + directions[i][1];
            dfs(image, visited, m, n, newRow, newCol, color);
        }
    }

    public static void main(String[] args) {

    }
}
