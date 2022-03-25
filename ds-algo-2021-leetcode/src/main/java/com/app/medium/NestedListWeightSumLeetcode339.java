package com.app.medium;

import java.util.List;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */

interface NestedInteger {
    //public NestedInteger();
     // Constructor initializes a single integer
    //public NestedInteger(int value);
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
   // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
   // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);
     // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedListWeightSumLeetcode339 {
    int sum = 0;

    private int depthSum(List<NestedInteger> nestedList) {
        depthSumRec(nestedList, 1);
        return sum;
    }

    private void depthSumRec(List<NestedInteger> nestedList, int currentDepth) {
        for(NestedInteger curr: nestedList) {
            if(curr.isInteger()) {
                sum += (currentDepth * curr.getInteger());
            } else {
                depthSumRec(curr.getList(), currentDepth + 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
