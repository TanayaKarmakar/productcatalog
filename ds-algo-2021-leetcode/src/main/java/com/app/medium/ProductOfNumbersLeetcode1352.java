package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */


class ProductOfNumbers {
  private List<Integer> productList;

  public ProductOfNumbers() {
    productList = new ArrayList<>();
  }

  public void add(int num) {
    if(num == 0)
      productList = new ArrayList<>();
    else {
      if(productList.size() == 0)
        productList.add(num);
      else
        productList.add(num * productList.get(productList.size() - 1));
    }
  }

  public int getProduct(int k) {
    if(k > productList.size())
      return 0;
    int n = productList.size();
    if(n == k)
      return productList.get(n - 1);
    else {
      int val1 = productList.get(n - 1);
      int val2 = productList.get(n - k - 1);
      return val1 / val2;
    }
  }
}


public class ProductOfNumbersLeetcode1352 {
  public static void main(String[] args) {

  }
}
