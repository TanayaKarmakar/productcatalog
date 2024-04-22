package com.app.medium.atlassian;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
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
    int x;
    int y;
    List<Point> foodPositions;
    List<Point> snake;


    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        foodPositions = new ArrayList<>();
        for(int i = 0; i < food.length; i++) {
            foodPositions.add(new Point(food[i][0], food[i][1]));
        }
        this.snake = new ArrayList<>();
        this.snake.add(new Point(0, 0));
    }

    public int move(String direction) {
        switch (direction) {
            case "U":
                if(!isValidMove(x - 1, y))
                    return -1;
                x--;
                changeSnakePosition();
                return snake.size() - 1;
            case "D":
                if(!isValidMove(x + 1, y))
                    return -1;
                x++;
                changeSnakePosition();
                return snake.size() - 1;
            case "L":
                if(!isValidMove(x, y - 1))
                    return -1;
                y--;
                changeSnakePosition();
                return snake.size() - 1;
            case "R":
                if(!isValidMove(x, y + 1))
                    return -1;
                y++;
                changeSnakePosition();
                return snake.size() - 1;
            default:
                throw new RuntimeException("Invalid input");
        }
    }

    private void changeSnakePosition() {
        Point newPos = new Point(x, y);
        this.snake.add(newPos);
        Point food = foodPositions.stream().findFirst().get();
        if(newPos.equals(food)) {
            foodPositions.remove(food);
        } else {
            Point firstSnakeEntry = snake.stream().findFirst().get();
            snake.remove(firstSnakeEntry);
        }
    }

    private boolean isValidMove(int x, int y) {
        if(x < 0 || x >= height || y < 0 || y >= width)
            return false;
        if(snake.contains(new Point(x, y)))
            return false;
        return true;
    }
}


public class DesignSnakeGameLeetcode353 {
    public static void main(String[] args) {

    }
}
