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
    private static final Deque<HumanBeing> humanCollection = new ArrayDeque<>();
    private static final DAO database = new ArrayDequeDAO();
    private static InputHandler reader;

    private static final Command[] commands = {
            new AddCommand(database),
            new UpdateCommand(database),
            // new ReadCommand(database),
            new RemoveCommand(database),
            new ScriptCommand(),
            new HelpCommand(),
            new ShowCommand(humanCollection, database),
            new ClearCommand(humanCollection),
            new InfoCommand(humanCollection)
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
    UPDATE,
    REMOVE_BY_ID,
    EXECUTE_SCRIPT,
    HELP,
    SHOW,
    CLEAR,
    INFO;
}