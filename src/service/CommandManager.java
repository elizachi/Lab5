package service;

import commands.*;
import dao.*;
import exceptions.EndException;
import handlers.*;
import handlers.ConsoleInputHandler;
import handlers.FileInputHandler;
import handlers.InputHandler;
import source.HumanBeing;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс обработчик, определяющий команду и ее поведение по отношению к входным данным
 */
public class CommandManager {
    private static final DAO database = new ArrayDequeDAO();
    private static InputHandler reader;

    private static final Command[] commands = {
            new AddCommand(database),
            new ClearCommand(database),
            new FilterByMinutesCommand(database),
            new HeadCommand(database),
            new HelpCommand(),
            new InfoCommand(database),
            new PrintUniqueSpeed(database),
            new RemoveCommand(database),
            new RemoveHeadCommand(database),
            new ScriptCommand(),
            new ShowCommand(database),
            new UpdateCommand(database)
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
     * Меняет тип считывания на считывание с файла.
     * Отключает дружественный интерфейс, если он включён
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
    CLEAR,
    FILTER_BY_MINUTES_OF_WAITING,
    HEAD,
    HELP,
    INFO,
    PRINT_UNIQUE_IMPACT_SPEED,
    REMOVE_BY_ID,
    REMOVE_HEAD,
    EXECUTE_SCRIPT,
    SHOW,
    UPDATE;
}