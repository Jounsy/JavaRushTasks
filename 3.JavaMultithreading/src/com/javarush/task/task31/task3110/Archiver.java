package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Work-TESTER on 16.08.2017.
 */
public class Archiver {
    public static void main(String[] args) {


        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);


    }

    public static Operation askOperation() throws IOException{
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - добавить файл в архив");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - удалить файл из архива");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - распаковать архив");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - просмотреть содержимое архива");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - выход");

        int operationNumber =  ConsoleHelper.readInt();
        if (operationNumber==Operation.CREATE.ordinal())
            return Operation.CREATE;
        if (operationNumber==Operation.ADD.ordinal())
            return Operation.ADD;
        if (operationNumber==Operation.REMOVE.ordinal())
            return Operation.REMOVE;
        if (operationNumber==Operation.EXTRACT.ordinal())
            return Operation.EXTRACT;
        if (operationNumber==Operation.CONTENT.ordinal())
            return Operation.CONTENT;
        if (operationNumber==Operation.EXIT.ordinal())
            return Operation.EXIT;
        return null;
    }
}
