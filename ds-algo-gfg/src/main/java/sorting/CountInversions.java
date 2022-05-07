package sorting;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class CountInversions {
    private static int count(int[] nums) {
        return countInvRec(nums, 0, nums.length - 1);
    }

    private static int countInvRec(int[] nums, int start, int end) {
        if(start == end)
            return 0;
        int mid = (start + end) >> 1;
        int res = countInvRec(nums, start, mid);
        res += countInvRec(nums, mid + 1, end);
        res += countInvMerge(nums, start, mid, end);
        return res;
    }

    private static int countInvMerge(int[] nums, int start, int mid, int end) {
        int n1 = (mid - start + 1);
        int n2 = (end - mid);
        int[] left = new int[n1];
        int[] right = new int[n2];

        int i1 = 0;
        for(int i = start; i <= mid; i++) {
            left[i1++] = nums[i];
        }

        i1 = 0;
        for(int i = mid + 1; i <= end; i++) {
            right[i1++] = nums[i];
        }

        int i = 0;
        int j = 0;
        i1 = start;
        int count = 0;
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                nums[i1++] = left[i++];
            } else {
                nums[i1++] = right[j++];
                count += (n1 - i);
            }
        }

        while(i < n1) {
            nums[i1++] = left[i++];
        }

        while(j < n2) {
            nums[i1++] = right[j++];
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
