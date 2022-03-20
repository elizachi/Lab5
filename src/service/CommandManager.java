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
            new RemoveCommand(database),
            new ScriptCommand(),
            new FilterByMinutesCommand(database)
    };

    /**
     * Меняет тип считывания на считывание с консоли
     */
    public static void turnOnConsole() {
        reader = new ConsoleInputHandler();
        // Возврат к дружественному интерфейсу после считывания с файла, если оно было
        AskInput.returnFriendly();
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
            System.err.print(e.getMessage());
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
    EXECUTE_SCRIPT,
    FILTER_BY_MINUTES_OF_WAITING;
}