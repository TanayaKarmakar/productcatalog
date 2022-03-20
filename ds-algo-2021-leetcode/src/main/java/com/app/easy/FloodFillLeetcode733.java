package com.app.easy;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class FloodFillLeetcode733 {
    private static void floodFillRec(int[][] image, boolean[][] visited, int sr, int sc, int startPixelColor, int newColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != startPixelColor)
            return;
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        floodFillRec(image, visited, sr - 1, sc, startPixelColor, newColor);
        floodFillRec(image, visited, sr + 1, sc, startPixelColor, newColor);
        floodFillRec(image, visited, sr, sc - 1, startPixelColor, newColor);
        floodFillRec(image, visited, sr, sc + 1, startPixelColor, newColor);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int startPixelColor = image[sr][sc];

        floodFillRec(image, visited, sr, sc, startPixelColor, newColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

        floodFill(image, 1,1, 2);

        for(int i  = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
