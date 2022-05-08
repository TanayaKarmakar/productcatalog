package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class CycleSort {
    private static int swap(int[] nums, int item, int pos) {
        int tmp = item;
        item = nums[pos];
        nums[pos] = tmp;
        return item;
    }

    private static void cycleSortDistinct(int[] nums) {
        int n = nums.length;
        for(int cs = 0; cs < n - 1; cs++) {
            int pos = cs;
            int item = nums[cs];
            for(int i = cs + 1; i < n; i++) {
                if(nums[i] < item)
                    pos++;
            }
            item = swap(nums, item, pos);
            while(pos != cs) {
                pos = cs;
                for(int i = cs + 1; i < n; i++) {
                    if(nums[i] < item)
                        pos++;
                }
                item = swap(nums, item, pos);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {40, 10,30, 20,50};

        cycleSortDistinct(nums);

        System.out.println(Arrays.toString(nums));
    }
}
