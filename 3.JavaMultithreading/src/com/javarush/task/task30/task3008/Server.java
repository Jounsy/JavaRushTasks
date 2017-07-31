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
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{

            for(Map.Entry<String,Connection> entry: connectionMap.entrySet()){
                if(userName!=entry.getKey()){
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{

            while (true) {
                Message message = connection.receive();
                String messageText = null;

                if(message.getType() == MessageType.TEXT){
                    messageText = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT,messageText));
                }
                else{
                    ConsoleHelper.writeMessage("Сообщение не ТЕКСТ");
                }
            }
        }

        public void run(){

            Connection connection = null;
            String userName = null;
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            try {
                connection = new Connection(socket);
                userName =  serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection,userName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным сервером");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным сервером");
            }
            if (userName!=null){
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным сервером закрыто " + connection.getRemoteSocketAddress());
            }






        }

    }
}
