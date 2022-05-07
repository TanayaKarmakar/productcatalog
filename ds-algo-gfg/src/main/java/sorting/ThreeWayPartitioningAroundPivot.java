package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/05/22
 * @project ds-algo-2021
 */
public class ThreeWayPartitioningAroundPivot {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void partition(int[] nums, int pivot) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            int el = nums[mid];
            if(el < pivot) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(el == pivot)
                mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,20,10,20,1};
        int pivot = 2;

        partition(nums, pivot);

        System.out.println(Arrays.toString(nums));
    }
}
