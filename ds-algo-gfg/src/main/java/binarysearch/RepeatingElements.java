package binarysearch;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class RepeatingElements {
    private static int findRepeating(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 2, 2};
        int ans = findRepeating(nums);

        System.out.println(ans);
    }
}
