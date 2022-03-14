package dp;

/**
 * @author t0k02w6 on 13/03/22
 * @project ds-algo-2021
 */
public class PaintHouse2ManyColors {
    private static int minCostOptimized(int[][] colors) {
        int m =colors.length;
        int n = colors[0].length;
        int[][] dp = new int[m][n];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(colors[0][i] < least) {
                sleast = least;
                least = colors[0][i];
            } else if(colors[0][i] < sleast) {
                sleast = colors[0][i];
            }
            dp[0][i] = colors[0][i];
        }

        for(int i = 1; i < m; i++) {
            int nsleast = Integer.MAX_VALUE;
            int nleast = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                int value = 0;
                if(dp[i - 1][j] == least) {
                    value = colors[i][j] + sleast;
                } else {
                    value = colors[i][j] + least;
                }
                dp[i][j] = value;
                if(value < nleast) {
                    nsleast = nleast;
                    nleast = value;
                } else if(value < nsleast) {
                    nsleast = value;
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        int finalMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            finalMin = Integer.min(finalMin, dp[m - 1][i]);
        }
        return finalMin;
    }

    private static int minCost(int[][] colors) {
        int m = colors.length;
        int n = colors[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = colors[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++) {
                    if(j != k) {
                        min = Integer.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = colors[i][j] + min;
            }
        }

        int finalMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            finalMin = Integer.min(finalMin, dp[m - 1][i]);
        }
        return finalMin;
    }

    public static void main(String[] args) {
        int[][] colors = {{1,5,7,2,1,4},{5,8,4,3,6,1},{3,2,9,7,2,3},{1,2,4,9,1,7}};
        int ans = minCost(colors);

        System.out.println("O(n^3) approach - " + ans);


        ans = minCostOptimized(colors);

        System.out.println("O(n^2) approach - " + ans);


    }
}
