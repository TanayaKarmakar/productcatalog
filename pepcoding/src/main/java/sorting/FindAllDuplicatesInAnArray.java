package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 27/03/22
 * @project ds-algo-2021
 */
public class FindAllDuplicatesInAnArray {
    private static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            while(nums[i] != (i + 1)) {
                int tmp = nums[i];
                if(nums[tmp - 1] == tmp)
                    break;
                int tmp1 = nums[tmp - 1];
                nums[i] = tmp1;
                nums[tmp - 1] = tmp;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1)) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates(nums);

        System.out.println(list);

        nums = new int[] {1,1,2};
        list = findDuplicates(nums);

        System.out.println(list);
    }
}
