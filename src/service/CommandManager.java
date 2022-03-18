package service;

import commands.*;
import dao.*;
import exceptions.EndException;
import handlers.*;

import java.io.BufferedInputStream;

/**
 * Класс обработчик, определяющий команду и ее поведение по отношению к входным данным
 */
public class CommandManager {
    private static final DAO database = new ArrayDequeDAO();
    private static InputHandler reader;

    private static final Command[] commands = {
            new AddCommand(database),
            new UpdateCommand(database),
            // new ReadCommand(database),
            new RemoveCommand(database),
            new ScriptCommand()
    };

    /**
     * Меняет тип считывания на считывание с консоли
     */
    public static void turnOnConsole() {
        reader = new ConsoleInputHandler();
        AskInput.turnOnFriendly();
    }

    public static void turnOnConsole(String message) {
        System.out.print("\u001B[33m"+message+"\u001B[0m");
        reader = new ConsoleInputHandler();
        AskInput.turnOnFriendly();
    }
    /**
     * Меняет тип считывания на считывание с файла
     * Отключает дружетвенный интерфейс, если он включён
     */
    public static void turnOnFile(BufferedInputStream bufferedInput) {
        reader = new FileInputHandler(bufferedInput);
        AskInput.turnOffFriendly();
    }

    /**
     * Начало работы определителя команд
     */
    public static void whichCommand() {
        String command;
        try {
            command = AskInput.askCommand(reader);
        } catch(EndException e) {
            CommandManager.turnOnConsole(e.getMessage());
            whichCommand();
            return;
        }
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        commands[commandIndex].execute(reader);
        whichCommand();
    }
}

/**
 * Перечисление существующих команд
 */
enum CommandType {
    ADD,
    UPDATE,
    REMOVE_BY_ID,
    EXECUTE_SCRIPT;
}