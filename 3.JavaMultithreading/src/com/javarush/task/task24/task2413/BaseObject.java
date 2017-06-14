package com.javarush.task.task24.task2413;

/**
 * Created by Work-TESTER on 14.06.2017.
 */
public abstract class BaseObject {
    private double x,y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    boolean isIntersec(BaseObject o){
        boolean isCheck;
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        isCheck = destination <= destination2;
        return isCheck;
    }

    abstract void draw(Canvas canvas);

    abstract void move();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
