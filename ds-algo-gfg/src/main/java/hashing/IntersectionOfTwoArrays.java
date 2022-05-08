package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 08/05/22
 * @project ds-algo-2021
 */
public class IntersectionOfTwoArrays {
    private static int intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], false);
        }

        int count = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && !map.get(nums2[i])) {
                System.out.println(nums2[i]);
                count++;
                map.put(nums2[i], true);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {10,10,30,20};
        int[] nums2 = {20,10,40,10,40};

        int ans = intersection(nums1, nums2);

        System.out.println(ans);
    }
}
