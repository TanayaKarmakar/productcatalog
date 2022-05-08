package binarysearch;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class MedianOfTwoSortedArray {
    private static double median(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return median(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;

        int begin = 0;
        int end = n1 - 1;

        while(begin <= end) {
            int i1 = (begin + end) / 2;
            int i2 = ((n1 + n2 + 1) / 2) - i1;
            int max1 = (i1 == 0) ? Integer.MIN_VALUE: nums1[i1 - 1];
            int min1 = (i1 == n1) ? Integer.MAX_VALUE: nums1[i1];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE: nums2[i2 - 1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE: nums2[i2];

            if(max1 <= min2 && max2 <= min1) {
                int min = Integer.min(min1, min2);
                int max = Integer.max(max1, max2);
                if((n1 + n2) % 2 != 0)
                    return Double.max(min, max);
                else
                    return (min + max)/ 2.0;
            }else if(max1 > min2)
                end = i1 - 1;
            else
                begin = i1 + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {30,40,50,60};
        int[] nums2 = {5,6,7,8,9};

        double ans = median(nums1, nums2);

        System.out.println(ans);
    }
}
