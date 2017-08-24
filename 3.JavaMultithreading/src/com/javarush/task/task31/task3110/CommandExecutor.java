package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Work-TESTER on 23.08.2017.
 */
public class CommandExecutor {

    private CommandExecutor(){}

private final static Map<Operation, Command> allKnownCommandsMap = new HashMap<>();
   static  {
        allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
        allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
    }

    public static void execute(Operation operation) throws Exception{
          allKnownCommandsMap.get(operation).execute();
    }

}