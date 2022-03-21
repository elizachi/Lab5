package service;

import commands.*;
import dao.ArrayDequeDAO;
import dao.DAO;
import exceptions.EndException;
import exceptions.JumpReaderException;

import java.util.jar.JarException;

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

public class CommandManager {

    private static final DAO database = new ArrayDequeDAO();

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
     * Начало работы определителя команд
     */
    public static void whichCommand() {
        String command;
        try {
            command = AskInput.askCommand(ReaderManager.getReader());
        } catch(EndException | JumpReaderException e) {
            System.err.print(e.getMessage());
            whichCommand();
            return;
        }
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        commands[commandIndex].execute(ReaderManager.getReader());
        whichCommand();
    }
}