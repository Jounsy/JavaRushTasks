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

   void run()
   {
       for(int i = 1;i<=100;i++)
       {
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           move();
           print();
       }
   }
   public void move()
   {
       for (Horse horsesList: getHorses())
       {
           horsesList.move();
       }
   }
   public void print()
   {
       for (Horse horsesList: getHorses())
       {
           horsesList.print();
       }
       for (int i = 0;i<10;i++)
       {
           System.out.println();
       }
   }
   public Horse getWinner()
   {
       Horse winner = null;
       int dotsCount = 0;

       for (Horse horsesList: getHorses())
       {
          if ((int)horsesList.getDistance()>dotsCount)
          {
              winner = horsesList;
              dotsCount = (int)horsesList.getDistance();
          }
       }
       return winner;
   }
   public void printWinner()
   {
       System.out.println("Winner is " + getWinner().getName() + "!");
   }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList());

        game.getHorses().add(new Horse("Tattoo",3.0,0.0));
        game.getHorses().add(new Horse("Eclipse",3.0,0.0));
        game.getHorses().add(new Horse("Idea",3.0,0.0));

        game.run();

    }
}
