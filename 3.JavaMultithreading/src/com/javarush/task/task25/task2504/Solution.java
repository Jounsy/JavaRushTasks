package com.javarush.task.task25.task2504;


/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        Thread[] threadsArray = threads;
        for(int i = 0; i < threadsArray.length;i++){
            Thread.State state = threadsArray[i].getState();

            switch (state) {
                case NEW: if(!threadsArray[i].isAlive()) threadsArray[i].start();
                break;
                case WAITING:
                    threadsArray[i].interrupt();
                    break;
                case TIMED_WAITING:
                    threadsArray[i].interrupt();
                    break;
                case BLOCKED:
                    threadsArray[i].interrupt();
                    break;
                case RUNNABLE: threadsArray[i].isInterrupted();
                break;
                case TERMINATED:
                    System.out.println(threadsArray[i].getPriority());
                    break;
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
