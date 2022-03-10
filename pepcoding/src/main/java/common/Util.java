package common;

/**
 * @author t0k02w6 on 05/03/22
 * @project ds-algo-2021
 */
public class Util {
    public static int factorial(int n) {
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void display2DArray(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
