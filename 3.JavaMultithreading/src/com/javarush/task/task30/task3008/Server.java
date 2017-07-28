package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Work-TESTER on 28.07.2017.
 */
public class Server {

private static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите номер порта");

        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void sendBroadcastMessage(Message message){

        for(Map.Entry<String,Connection> entry: connectionMap.entrySet()){
            if(entry.getKey()!=null){
                try {
                    entry.getValue().send(message);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Ну не шмагла!" + entry.getKey());
                }
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{

            while (true) {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message message = connection.receive();

                if(message.getType()==MessageType.USER_NAME){
                    String userName = message.getData();
                    if(!userName.isEmpty() && userName!=null && !connectionMap.containsKey(userName)){
                        connectionMap.put(userName,connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }

                }
            }

//            return null;
        }
    }
}
