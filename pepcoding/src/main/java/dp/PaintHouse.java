package dp;

/**
 * @author t0k02w6 on 13/03/22
 * @project ds-algo-2021
 */
public class PaintHouse {
    private static int minCost(int[][] colors) {
        int n = colors.length;
        int redInc = colors[0][0];
        int blueInc = colors[0][1];
        int greenInc = colors[0][2];

        for(int i = 1; i < n; i++) {
            int newRedInc = colors[i][0] + Integer.min(blueInc, greenInc);
            int newBlueInc = colors[i][1] + Integer.min(redInc, greenInc);
            int newGreenInc = colors[i][2] + Integer.min(redInc, blueInc);
            redInc = newRedInc;
            blueInc = newBlueInc;
            greenInc = newGreenInc;
        }
        return Integer.min(redInc, Integer.min(greenInc, blueInc));
    }

    public static void main(String[] args) {
        int[][] colors = {{1,5,7},{5,8,7},{3,2,9},{1,2,4}};
        int ans = minCost(colors);

        System.out.println(ans);
    }
}
