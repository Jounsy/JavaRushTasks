package com.javarush.task.task25.task2506;

/**
 * Created by Work-TESTER on 30.06.2017.
 */
public class LoggingStateThread extends Thread{

    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public LoggingStateThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {

        State nowState = null;

        while(!thread.isInterrupted()){
            if(nowState!=thread.getState()) {
                nowState = thread.getState();
                System.out.println(nowState);
            }
            if(nowState.toString() == "TERMINATED"){
                thread.interrupt();
                break;
            }
        }
    }
}
