package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/05/22
 * @project ds-algo-2021
 */
public class BubbleSort {
    private static void sort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < (n - 1); i++) {
            boolean swapped = false;
            for(int j = 0; j < (n - i - 1); j++) {
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,8,20,5};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
