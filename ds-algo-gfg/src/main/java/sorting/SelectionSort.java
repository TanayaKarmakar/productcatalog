package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/05/22
 * @project ds-algo-2021
 */
public class SelectionSort {
    private static void sort(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int last = (n - i - 1);
            int maxIndx = 0;
            for(int j = 0; j <= last; j++) {
                if(nums[maxIndx] < nums[j]) {
                    maxIndx = j;
                }
            }
            int tmp = nums[last];
            nums[last] = nums[maxIndx];
            nums[maxIndx] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,20,2,18};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
