package com.app.medium;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class StringCompressionLeetcode443 {
  private static int compress(char[] chars) {
    int n = chars.length;
    int count = 1;
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < n;) {
      int j = i + 1;
      count = 1;
      while(j < n && chars[i] == chars[j]) {
        count++;
        j++;
      }
      sb.append(chars[i]);
      if(count > 1)
        sb.append(count);
      i = j;
    }
    for(int i = 0; i < sb.length(); i++) {
      chars[i]= sb.charAt(i);
    }
    //System.out.println(sb);
    return sb.length();
  }

  public static void main(String[] args) {
    System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    System.out.println(compress(new char[]{'a'}));
    System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
  }
}
