package com.javarush.task.task29.task2909.human;

/**
 * Created by Work-TESTER on 06.07.2017.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }
    public void fight() {
    }
}
