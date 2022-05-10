package hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 08/05/22
 * @project ds-algo-2021
 */
public class UnionOfTwoSortedArrays {
    private static List<Integer> union(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums1 = {10,30,10};
        int[] nums2 = {5,10,5};

        List<Integer> result = union(nums1, nums2);

        System.out.println(result);
    }
}
