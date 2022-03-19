package dp;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class BuyAndSellStocksInfiniteTxnCooldown {
    private static int maxProfit(int[] nums) {
        int obsp = -nums[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i = 1; i < nums.length; i++) {
            int nbsp = Integer.max(obsp, ocsp - nums[i]);
            int nssp = Integer.max(ossp, obsp + nums[i]);
            int ncsp = Integer.max(ocsp, ossp);

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        return ossp;
    }

    public static void main(String[] args) {
        int[] nums = {10,15,17,20,16,18,22,20,22,20,23,25};

        int ans = maxProfit(nums);

        System.out.println(ans);
    }
}
