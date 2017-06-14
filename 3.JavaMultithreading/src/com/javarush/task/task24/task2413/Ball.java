package com.javarush.task.task24.task2413;

/**
 * Created by Work-TESTER on 14.06.2017.
 */
public class Ball extends BaseObject {

    private double speed;
    private double direction;
    private double dx = speed * direction;
    private double dy = speed * direction;
    private boolean isFrozen = true;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
