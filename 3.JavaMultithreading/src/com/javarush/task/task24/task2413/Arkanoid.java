package com.javarush.task.task24.task2413;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Work-TESTER on 14.06.2017.
 */
public class Arkanoid {
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    static Arkanoid game;
    private boolean isGameOver;

    public Arkanoid(int width, int height){
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }
    public void move(){
        ball.move();
        stand.move();
    }

    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for(Brick eachBrick: bricks)
         {
           eachBrick.draw(canvas);
         }
    }

    public void checkBricksBump(){

        for (Brick eachBrick: bricks) {
            if(ball.isIntersec(eachBrick)){
                bricks.remove(eachBrick);
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                break;
            }
        }
    }

    public void checkStandBump(){
       if(ball.isIntersec(stand)){
         double angle = 90 + 20 * (Math.random() - 0.5);
         ball.setDirection(angle);
       }
    }

    public void checkEndGame(){
        if(ball.y > height){
            isGameOver = true;
        }
    }

    public void run(){}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
