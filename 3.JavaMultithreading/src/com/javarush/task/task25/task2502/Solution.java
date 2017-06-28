package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<>();
            Wheel[] wheel = Wheel.values();
            String[] wheelBlank = loadWheelNamesFromDB();
            for(int i = 0; i < wheel.length; i++){
                if (wheelBlank.length==4) {
                    if(wheel[i].toString() == wheelBlank[0] || wheel[i].toString() == wheelBlank[1] || wheel[i].toString() == wheelBlank[2] || wheel[i].toString() == wheelBlank[3]){
                     wheels.add(Wheel.valueOf(wheelBlank[i]));
                    }
                    else{
                     throw new IllegalArgumentException();
                    }
                }
                else{
                    throw new IllegalArgumentException();
                }
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.wheels);
    }
}
