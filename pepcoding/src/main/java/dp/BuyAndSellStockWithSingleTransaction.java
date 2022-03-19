package dp;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class BuyAndSellStockWithSingleTransaction {
    private static int maxProfit(int[] nums) {
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = 0;
        for(int i = 0; i < nums.length; i++) {
            minPrice = Integer.min(minPrice, nums[i]);
            totalProfit = Integer.max(totalProfit, nums[i] - minPrice);
        }
        return totalProfit;
    }

    public static void main(String[] args) {

    }
}
