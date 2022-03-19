package dp;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class BuyAndSellStocksInfiniteTxnWithFees {
    private static int maxProfit(int[] nums, int fee) {
        int[] boughtStateProfit = new int[nums.length];
        int[] soldStateProfit = new int[nums.length];

        boughtStateProfit[0] = -nums[0];

        for(int i = 1; i < nums.length; i++) {
            boughtStateProfit[i] = Integer.max(boughtStateProfit[i - 1], soldStateProfit[i - 1] - nums[i]);
            soldStateProfit[i] = Integer.max(soldStateProfit[i - 1], boughtStateProfit[i - 1] + nums[i] - fee);
        }
        return soldStateProfit[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {10,15,17,20,16,18,22,20,22,20,23,25};
        int fee = 3;

        int ans = maxProfit(nums, fee);

        System.out.println(ans);
    }
}
