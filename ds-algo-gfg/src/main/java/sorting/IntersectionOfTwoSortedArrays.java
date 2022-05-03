package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class IntersectionOfTwoSortedArrays {
    private static int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while(i < m && j < n) {
            if(nums1[i] == nums2[j]) {
                if(result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            } else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }

        int[] res = new int[result.size()];
        i = 0;
        for(Integer el: result) {
            res[i++] = el;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,3,3,3};
        int[] nums2 = {1,1,1,1,3,5};

        int[] res = intersection(nums1, nums2);

        System.out.println(Arrays.toString(res));

        nums1 = new int[] {10,20,20,40,60};
        nums2 = new int[] {2,10,20,20,20};

        res = intersection(nums1, nums2);

        System.out.println(Arrays.toString(res));
    }
}
