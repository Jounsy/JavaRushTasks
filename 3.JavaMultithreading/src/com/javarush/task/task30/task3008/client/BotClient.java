package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Work-TESTER on 07.08.2017.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);
            String userName;
            String text;

            if (message.contains(": ")) {
                String textMessage[] = message.split(": ", 2);
                userName = textMessage[0];
                text = textMessage[1];


                SimpleDateFormat formatDate = null;

                if (text.equals("дата")) {
                    formatDate = new SimpleDateFormat("d.MM.YYYY");
                } else if (text.equals("день")) {
                    formatDate = new SimpleDateFormat("d");
                } else if (text.equals("месяц")) {
                    formatDate = new SimpleDateFormat("MMMM");
                } else if (text.equals("год")) {
                    formatDate = new SimpleDateFormat("YYYY");
                } else if (text.equals("время")) {
                    formatDate = new SimpleDateFormat("H:mm:ss");
                } else if (text.equals("час")) {
                    formatDate = new SimpleDateFormat("H");
                } else if (text.equals("минуты")) {
                    formatDate = new SimpleDateFormat("m");
                } else if (text.equals("секунды")) {
                    formatDate = new SimpleDateFormat("s");
                }
                if (!(formatDate == null)) {
                    sendTextMessage("Информация для " + userName + ": " + formatDate.format(Calendar.getInstance().getTime()));
                }

            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();

        }
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
