package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 18.05.2017.
 */
public class Hippodrome {

    static Hippodrome game;
    public Hippodrome(List horses)
    {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> horses;

   void run(){}
   void move(){}
   void print(){}
    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList());

        game.getHorses().add(new Horse("Tattoo",3.0,0.0));
        game.getHorses().add(new Horse("Eclipse",3.0,0.0));
        game.getHorses().add(new Horse("Idea",3.0,0.0));




    }
}
