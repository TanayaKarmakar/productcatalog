package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/05/22
 * @project ds-algo-2021
 */
public class ThreeWayPartitioningAroundARange {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void partition(int[] nums, int[] range) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            int el = nums[mid];
            if(el < range[0]) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(el >= range[0] && el <= range[1])
                mid++;
            else {
                swap(nums, mid, high);
                high--;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {10,5,6,3,20,9,49};
        int[] range = {5,10};

        partition(nums, range);

        System.out.println(Arrays.toString(nums));
    }
}
