package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/05/22
 * @project ds-algo-2021
 */
public class InsertionSort {
    private static void sort(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            int k = i - 1;
            int el = nums[i];
            while(k >= 0 && nums[k] > el) {
                nums[k + 1] = nums[k];
                k--;
            }
            k = k + 1;
            nums[k] = el;
        }
    }

    public static void main(String[] args) {
        int[] nums = {20,5,40,60,10,30};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
