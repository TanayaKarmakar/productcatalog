package com.app.medium;


import java.util.List;

// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {
    // Constructor initializes an empty nested list.

    // Constructor initializes a single integer.

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

      static class Solution {
          private int sum = 0;

          public int depthSum(List<NestedInteger> nestedList) {
              sum = 0;
              depthSumRec(nestedList, 1);
              return sum;
          }

          private void depthSumRec(List<NestedInteger> nestedList, int currentLevel) {
              for(NestedInteger ni: nestedList) {
                  if(ni.isInteger()) {
                      sum += (currentLevel * ni.getInteger());
                  } else {
                      depthSumRec(ni.getList(), currentLevel + 1);
                  }
              }
          }
      }
    public static void main(String[] args) {

    }
}
