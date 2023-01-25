package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 03/01/23
 * @project ds-algo-2021
 */
class SnakeGame {
  Queue<int[]> foodQ;
  int boardWidth;
  int boardHeight;
  int startX;
  int startY;
  int endX;
  int endY;
  int currentLen;
  int currentScore;

  public SnakeGame(int width, int height, int[][] food) {
    this.boardHeight = height;
    this.boardWidth = width;
    this.currentLen = 1;
    foodQ = new LinkedList<>();
    for(int[] current: food) {
      foodQ.add(current);
    }
  }

  public int move(String direction) {
    moveDirection(direction);
    if(startX < 0 || startX >= boardWidth || startY < 0 || startY >= boardHeight)
      return -1;
    if(foodQ.isEmpty())
      return currentScore;
    else if(startX == foodQ.peek()[0] && startY == foodQ.peek()[1]) {
      currentScore++;
      currentLen++;
      if(currentLen >= boardHeight || currentLen >= boardWidth)
        return -1;
      foodQ.poll();
      return currentScore;
    }
    return currentScore;
  }

  private void moveDirection(String direction) {
    switch (direction) {
      case "U":
        startY--;
        endY = startY + currentLen;
        break;
      case "D":
        startY++;
        endY = startY + currentLen;
        break;
      case "L":
        startX--;
        endX = startX + currentLen;
        break;
      case "R":
        startX++;
        endX = startX + currentLen;
        break;
    }
  }
}

public class SnakeGameLeetcode353 {
  public static void main(String[] args) {
    SnakeGame sg = new SnakeGame(3, 2, new int[][]{{1,2},{0,1}});
    System.out.println(sg.move("R"));
    System.out.println(sg.move("D"));
    System.out.println(sg.move("D"));
    System.out.println(sg.move("U"));
    System.out.println(sg.move("L"));
    System.out.println(sg.move("U"));
  }
}
