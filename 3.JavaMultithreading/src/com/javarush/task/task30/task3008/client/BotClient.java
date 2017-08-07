package com.javarush.task.task30.task3008.client;

/**
 * Created by Work-TESTER on 07.08.2017.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread{

    }

    @Override
    protected String getUserName() {
        int generatedInt = (int) (Math.random() * 100.);

        return "date_bot_"+ generatedInt;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
