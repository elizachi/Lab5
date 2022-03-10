package service;

import commands.*;
import dao.*;
import handlers.InputHandler;

/**
 * Класс обработчик, определяющий команду и ее поведение по отношению к входным данным.
 */
public class CommandManager {
    private static final DAO database = new ArrayDequeDAO();
    private InputHandler reader;

    private final Command[] commands = {
            new AddCommand(database),
            new UpdateCommand(database),
            new ReadCommand(database),
            new DeleteCommand(database)
    };

    public CommandManager(InputHandler reader) {
        this.reader = reader;
    }

    /**
     * Если нам надо поменять тип считывания, то мы делаем это здесь
     * @param reader
     */
    public void setReader(InputHandler reader) {
        this.reader = reader;
    }

    public void start(boolean is) {
        System.out.print("Пожалуйста, введите команду.\n");
        whichCommand(reader.read(is));
    }
    private void whichCommand(String command) {
        try {
            int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
            commands[commandIndex].execute(reader);
        } catch(IllegalArgumentException e) {
            System.err.print("Команада введена неверно. Повторите попытку.\n");
            start(false);
        }
    }
}
enum CommandType {
    ADD,
    UPDATE;
}