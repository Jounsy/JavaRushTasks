package com.javarush.task.task23.task2312;

/**
 * Created by Work-TESTER on 06.06.2017.
 */
public class Room {
    private int width, height;
    private Snake snake;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    private Mouse mouse;
    public static Room game;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public static void main(String[] args) {
    Snake snake = new Snake(100,100);
    game = new Room(300, 400, snake);

    snake.setDirection(SnakeDirection.DOWN);

    }
    public void run(){}
    public void print(){}

}
