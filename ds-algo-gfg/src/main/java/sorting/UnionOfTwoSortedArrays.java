package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class UnionOfTwoSortedArrays {
    private static int[] union(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        List<Integer> res = new ArrayList<>();

        while(i < m && j < n) {
            if(i > 0 && nums1[i - 1] == nums1[i]) {
                i++;
            }
            else if(j > 0 && nums2[j - 1] == nums2[j]) {
                j++;
            }
            else if(nums1[i] <= nums2[j]) {
                if(res.isEmpty() || res.get(res.size() - 1) != nums1[i])
                    res.add(nums1[i]);
                i++;
            } else {
                if(res.isEmpty() || res.get(res.size() - 1) != nums2[j])
                    res.add(nums2[i]);
                j++;
            }
        }

        while(i < m) {
            if((i > 0 && nums1[i - 1] != nums1[i]) && (res.isEmpty() || res.get(res.size() - 1) != nums1[i])) {
                res.add(nums1[i]);
            }
            i++;
        }

        while(j < n) {
            if((j > 0 && nums2[j - 1] != nums2[j]) && (res.isEmpty() || res.get(res.size() - 1) != nums2[j])) {
                res.add(nums2[j]);
            }
            j++;
        }

        int[] finalResult = new int[res.size()];
        i = 0;
        for(Integer el: res) {
            finalResult[i++] = el;
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,3,3,4,4};
        int[] nums2 = {4,4};

        int[] finalResult = union(nums1, nums2);

        System.out.println(Arrays.toString(finalResult));

        nums1 = new int[]{3,5,8};
        nums2 = new int[]{2,8,9,10,15};

        finalResult = union(nums1, nums2);

        System.out.println(Arrays.toString(finalResult));
    }
}
