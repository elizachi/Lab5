package service;

import commands.*;
import dao.*;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;

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
    }

    /**
     * Меняет тип считывания на считывание с файла
     * Отключает дружетвенный интерфейс, если он включён
     */
    public static void turnOnFile() {
        reader = new ConsoleInputHandler();
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
     * @param command - уже прошедшая проверку строка, содержащая команду
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
    EXECUTE_SCRIPT;
}