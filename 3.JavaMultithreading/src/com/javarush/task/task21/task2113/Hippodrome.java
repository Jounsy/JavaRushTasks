package com.javarush.task.task21.task2113;


import java.util.List;

/**
 * Created by Work-TESTER on 18.05.2017.
 */
public class Hippodrome {

    public Hippodrome(List horses)
    {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> horses;
    public static void main(String[] args) {

    }
}
