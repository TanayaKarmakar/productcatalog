package dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class LongestChain {
    private static int longestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);

        int n = pairs.length;
        int[] lis = new int[n];
        lis[0] = 1;
        int maxlen = 1;
        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
            maxlen = Integer.max(maxlen, lis[i]);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[][] pairs = {{5,24},{39,60},{15,28},{27,40},{50,90}};

        int ans = longestChain(pairs);

        System.out.println(ans);
    }
}
