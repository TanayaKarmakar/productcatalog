package com.app.medium;

import java.util.List;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */

interface BinaryMatrix {
  public int get(int row, int col);
  public List<Integer> getDimensions();
}

public class LeftMostColumnWithAtleastAOneLeetcode1428 {
  private static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dimensions = binaryMatrix.getDimensions();
    int nRow = dimensions.get(0);
    int nCol = dimensions.get(1);
    int minIndx = -1;
    int i = 0;
    int j = nCol - 1;

    while(i < nRow && j >= 0) {
      if(binaryMatrix.get(i, j) == 1) {
        minIndx = j;
        j--;
      } else {
        i++;
      }
    }
    return minIndx;
  }

  public static void main(String[] args) {

  }
}
