package service;

import commands.*;
import dao.*;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Класс обработчик, определяющий команду и ее поведение по отношению к входным данным.
 */
public class CommandManager {
    private static final DAO database = new ArrayDequeDAO();
    private static final InputHandler consoleReader = new ConsoleInputHandler();
    private static ArrayList<String> data_in;

    private static final Command[] commands = {
            new AddCommand(database),
            new UpdateCommand(database),
            new ReadCommand(database),
            new DeleteCommand(database)
    };

    public static void start(InputHandler reader) {
        System.out.print("Пожалуйста, введите команду.\n");
        data_in = reader.read();
        whichCommand(data_in);
    }
    private static void whichCommand(ArrayList <String> data_in) {
        String[] command = data_in.get(0).split(" ");
        try {
            if(command.length > 2) {
                throw new IllegalArgumentException();
            } else if(command.length == 2) {
                data_in.add(1, command[1]);
            }
            data_in.remove(0);
            int commandIndex = CommandType.valueOf(command[0].toUpperCase()).ordinal();
            if(commands[commandIndex].isCorrect(data_in)) {
                commands[commandIndex].execute(data_in);
            } else {
                start(consoleReader);
            }
        } catch(IllegalArgumentException e) {
            System.err.print("Неверный ввод!\n");
            start(consoleReader);
        }
    }
}
enum CommandType {
    ADD,
    UPDATE;
}