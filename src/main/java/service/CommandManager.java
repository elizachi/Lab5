package service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import commands.*;
import dao.*;
import exceptions.*;

import java.io.File;
import java.io.IOException;

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

    private static DAO database;

    static {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            DAODeserialize daoDeserialize = xmlMapper.readValue(new File(System.getenv("DAO_COLLECTION_FILEPATH")), DAODeserialize.class);

            database = daoDeserialize.deserialize();
        } catch (IOException ignored) {
            database = new ArrayDequeDAO();
        } finally {
            database.setAvailableId();
        }
    }

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
            new ExitCommand()
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