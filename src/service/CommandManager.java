package service;

import commands.*;
import dao.*;
import exceptions.*;

/**
 * Перечисление существующих команд
 */
enum CommandType {
    ADD,
    CLEAR,
    FILTER_BY_MINUTES_OF_WAITING,
    FILTER_GREATER_THAN_IMPACT_SPEED,
    HEAD,
    HELP,
    INFO,
    PRINT_UNIQUE_IMPACT_SPEED,
    REMOVE_BY_ID,
    REMOVE_GREATER,
    REMOVE_HEAD,
    EXECUTE_SCRIPT,
    SHOW,
    UPDATE,
    SAVE,
    EXIT;
}

public class CommandManager {

    private static final DAO database = new ArrayDequeDAO();

    private static final Command[] commands = {
            new AddCommand(database),
            new ClearCommand(database),
            new FilterByMinutesCommand(database),
            new FilterGreaterThanSpeedCommand(database),
            new HeadCommand(database),
            new HelpCommand(),
            new InfoCommand(database),
            new PrintUniqueSpeed(database),
            new RemoveByIdCommand(database),
            new RemoveGreaterCommand(database),
            new RemoveHeadCommand(database),
            new ScriptCommand(),
            new ShowCommand(database),
            new UpdateCommand(database),
            new SaveCommand(database),
            new ExitCommand(database)
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