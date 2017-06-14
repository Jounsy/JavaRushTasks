package com.javarush.task.task24.task2413;

/**
 * Created by Work-TESTER on 14.06.2017.
 */
public class Stand extends BaseObject {

    private double speed;
    private double direction;

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    void draw(Canvas canvas) {
    }

    @Override
    void move() {
        x += speed * direction;
    }

    public void draw(){}

    public void moveLeft(){
        direction = -1;
    }

    public void moveRight(){
        direction = 1;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
}
