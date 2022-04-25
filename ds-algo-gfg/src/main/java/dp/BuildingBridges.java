package dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class BuildingBridges {
    private static int maxBridge(int[][] bridges) {
        Arrays.sort(bridges, (b1, b2) -> {
            if(b1[0] == b2[0])
                return b1[1] - b2[1];
            return b1[0] - b2[0];
        });

        int maxLen = 1;
        int n = bridges.length;
        int[] lis = new int[n];
        lis[0] = 1;

        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(bridges[j][1] < bridges[i][1]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
            maxLen = Integer.max(maxLen, lis[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[][] bridges = {{6,2},{4,3},{2,6},{1,5}};

        int ans = maxBridge(bridges);

        System.out.println(ans);
    }
}
