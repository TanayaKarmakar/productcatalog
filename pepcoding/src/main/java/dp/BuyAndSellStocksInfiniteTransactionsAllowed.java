package dp;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class BuyAndSellStocksInfiniteTransactionsAllowed {
    private static int maxProfit(int[] nums) {
        int n = nums.length;
        int totalProfit = 0;

        int buyingDate = 0;
        int sellingDate = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] >= nums[i - 1])
                sellingDate++;
            else {
                totalProfit += (nums[sellingDate] - nums[buyingDate]);
                buyingDate = sellingDate = i;
            }
        }
        totalProfit += (nums[sellingDate] - nums[buyingDate]);
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};

        int ans = maxProfit(nums);

        System.out.println(ans);
    }
}
