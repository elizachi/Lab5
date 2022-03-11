package service;

import commands.*;
import dao.*;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;

/**
 * Класс обработчик, определяющий команду и ее поведение по отношению к входным данным.
 */
public class CommandManager {
    private static final DAO database = new ArrayDequeDAO();
    private static InputHandler reader;

    private static final Command[] commands = {
            new AddCommand(database),
            new UpdateCommand(database),
            new ScriptCommand(),
            new ReadCommand(database),
            new DeleteCommand(database)
    };

    /**
     * Если нам надо поменять тип считывания, то мы делаем это здесь
     */
    public static void turnOnConsole() {
        reader = new ConsoleInputHandler();
    }

    public static void turnOnFile() {
        reader = new ConsoleInputHandler();
        AskInput.turnOffFriendly();
    }

    public static void start() {
        whichCommand(AskInput.askCommand(reader));
    }
    private static void whichCommand(String command) {
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        commands[commandIndex].execute(reader);
        start();
    }
}
enum CommandType {
    ADD,
    UPDATE,
    EXECUTE_SCRIPT;
}