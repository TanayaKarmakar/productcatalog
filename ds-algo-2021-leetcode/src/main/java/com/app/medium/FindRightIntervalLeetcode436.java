package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
class IntervalNode {
    int start;
    int end;
    int indx;

    public IntervalNode(int start, int end, int indx) {
        this.start = start;
        this.end = end;
        this.indx = indx;
    }
}

public class FindRightIntervalLeetcode436 {
    private static int findCeiling(IntervalNode[] iNodes, int start, int end) {
        if(start > end)
            return -1;
        IntervalNode iNode = iNodes[start - 1];

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(iNodes[mid].start >= iNode.end && (mid - 1) >= 0 && iNodes[mid - 1].start < iNode.end)
                return iNodes[mid].indx;
            else if(iNodes[mid].start >= iNode.end)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        IntervalNode[] iNodes = new IntervalNode[n];

        for(int i = 0; i < n; i++) {
            IntervalNode iNode = new IntervalNode(intervals[i][0], intervals[i][1], i);
            iNodes[i] = iNode;
        }

        Arrays.sort(iNodes, (i1, i2) -> {
            if(i1.start == i2.start)
                return i1.end - i2.end;
            return i1.start - i2.start;
        });

        int[] res = new int[n];
        res[iNodes[n - 1].indx] = -1;
        for(int i = n - 2; i >= 0; i--) {
            res[iNodes[i].indx] = findCeiling(iNodes, i + 1, n - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};

        int[] res = findRightInterval(intervals);

        System.out.println(Arrays.toString(res));

    }
}
