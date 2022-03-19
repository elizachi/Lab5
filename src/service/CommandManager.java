package service;

import commands.*;
import dao.*;
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
            new HeadCommand(database),
            new HelpCommand(),
            new InfoCommand(database),
            // new ReadCommand(database),
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
    public static void start() {
        whichCommand(AskInput.askCommand(reader));
    }

    /**
     * По полученной строке определяет команду и совершает её вызов
     * @param command уже прошедшая проверку строка, содержащая команду
     */
    private static void whichCommand(String command) {
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        commands[commandIndex].execute(reader);
        start();
    }
}

/**
 * Перечисление существующих команд
 */
enum CommandType {
    ADD,
    CLEAR,
    HEAD,
    HELP,
    INFO,
    REMOVE_BY_ID,
    REMOVE_HEAD,
    EXECUTE_SCRIPT,
    SHOW,
    UPDATE;
}
