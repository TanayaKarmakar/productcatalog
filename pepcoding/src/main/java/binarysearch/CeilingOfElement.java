package binarysearch;

/**
 * @author t0k02w6 on 29/03/22
 * @project ds-algo-2021
 */
public class CeilingOfElement {
    private static int ceiling(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target)
                return nums[mid];
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,14,16,18};
        int target = 15;

        int ans = ceiling(nums, target);
        System.out.println("Index - " + ans + ", Element - " + nums[ans]);
    }
}
