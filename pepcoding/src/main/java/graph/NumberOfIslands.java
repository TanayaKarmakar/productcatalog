package graph;

/**
 * @author t0k02w6 on 05/03/22
 * @project ds-algo-2021
 */
public class NumberOfIslands {
    private static void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
            || visited[i][j] || matrix[i][j] == 1)
            return;
        visited[i][j] = true;
        dfs(matrix, visited, i - 1, j);
        dfs(matrix, visited, i + 1, j);
        dfs(matrix, visited, i, j - 1);
        dfs(matrix, visited, i, j + 1);
    }

    private static int numberOfIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0 && !visited[i][j]) {
                    count++;
                    dfs(matrix, visited, i, j);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] matrix = {{0,0,1,1,1,1,1,1},{0,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,0},{1,1,0,0,0,1,1,0},
                {1,1,1,1,0,1,1,0},{1,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,0}};

        int count = numberOfIslands(matrix);

        System.out.println(count);
    }
}
