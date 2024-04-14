package com.app.hard;

public class MedianOfTwoSortedArrayLeetcode4 {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1)/2;

        while(low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }

            if(mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            if(mid1 < n1) {
                r1 = nums1[mid1];
            }

            if(mid2 < n2) {
                r2 = nums2[mid2];
            }

            if(l1 <= r1 && l2 <= r2) {
                if((n1 + n2) % 2 != 0) {
                    return Double.max(l1, l2);
                } else {
                    return (Double.max(l1, l2) + Double.min(r1, r2))/2.0;
                }
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,4,7,10,12};
        int[] nums2 = {2,3,6,15};
        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
}