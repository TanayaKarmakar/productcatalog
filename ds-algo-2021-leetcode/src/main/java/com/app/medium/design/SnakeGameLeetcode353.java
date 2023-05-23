package com.app.medium.design;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author t0k02w6 on 20/05/23
 * @project ds-algo-2021-leetcode
 */
class SnakeGame {

  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Point point = (Point) o;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  int width;
  int height;
  LinkedHashSet<Point> snake;
  LinkedHashSet<Point> food;
  int x;
  int y;

  public SnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;
    this.food = new LinkedHashSet<>();
    for(int i = 0; i < food.length; i++) {
      this.food.add(new Point(food[i][0], food[i][1]));
    }
    this.snake = new LinkedHashSet<>();
    this.snake.add(new Point(0, 0));
    this.x = 0;
    this.y = 0;
  }

  public int move(String direction) {
    switch (direction) {
      case "U":
        if(!isValidMove(x - 1, y))
          return -1;
        x--;
        changeSnakeSize();
        return snake.size() - 1;
      case "D":
        if(!isValidMove(x + 1, y))
          return -1;
        x++;
        changeSnakeSize();
        return snake.size() - 1;
      case "L":
        if(!isValidMove(x, y - 1))
          return -1;
        y--;
        changeSnakeSize();
        return snake.size() - 1;
      case "R":
        if(!isValidMove(x, y + 1))
          return -1;
        y++;
        changeSnakeSize();
        return snake.size() - 1;
      default:
        throw new RuntimeException("Invalid entry");
    }
  }

  private void changeSnakeSize() {
    Point firstPos = this.food.stream().findFirst().get();
    this.snake.add(new Point(x, y));
    if(firstPos.equals(new Point(x, y))) {
      this.food.remove(firstPos);
    } else {
      Point oldestEntry = this.snake.stream().findFirst().get();
      snake.remove(oldestEntry);
    }
  }

  private boolean isValidMove(int x, int y) {
    if(snake.contains(new Point(x, y)))
      return false;
    if(x < 0 || x >= height)
      return false;
    if(y < 0 || y >= width)
      return false;
    return true;
  }
}


public class SnakeGameLeetcode353 {
  public static void main(String[] args) {
    SnakeGame snakeGame = new SnakeGame(3, 2, new int[][] {{1, 2}, {0, 1}});
    System.out.println(snakeGame.move("R")); // return 0
    System.out.println(snakeGame.move("D")); // return 0
    System.out.println(snakeGame.move("R")); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
    System.out.println(snakeGame.move("U")); // return 1
    System.out.println(snakeGame.move("L")); // return 2, snake eats the second food. No more food appears.
    System.out.println(snakeGame.move("U"));
  }
}
