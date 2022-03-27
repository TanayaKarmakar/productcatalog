package sorting;

/**
 * @author t0k02w6 on 27/03/22
 * @project ds-algo-2021
 */
public class FindTheDuplicateNumber {
    private static int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] != (i + 1)) {
                int tmp = nums[i];
                if(nums[tmp - 1] == tmp)
                    break;
                int tmp1 = nums[tmp - 1];
                nums[tmp - 1] = tmp;
                nums[i] = tmp1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1))
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        System.out.println(findDuplicate(nums));
    }
}
