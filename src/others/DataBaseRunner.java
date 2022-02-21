package others;

import commands.*;
import dao.ArrayDequeDAO;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;

import java.util.Objects;

enum CommandType {
    ADD("1"),
    UPDATE("2");
    private String title;

    CommandType(String type) {
        this.title = type;
    }

    public String getTitle() {
        return title;
    }

}
// TODO придумать что сделать с разными по параметрам командами
public class DataBaseRunner {

    public static void main(String [] args) {
        ArrayDequeDAO database = new ArrayDequeDAO();

        Command[] commands = {
                new AddCommand(database),
                new UpdateCommand(database),
                new ReadCommand(database),
                new DeleteCommand(database)
        };

        InputHandler reader = new ConsoleInputHandler();
        String input = reader.read();
        String command = InputHandler.getFirstWord(input);
        String arguments = reader.getArguments(input);

        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        String title = CommandType.valueOf(command.toUpperCase()).getTitle();
        if(Objects.equals(title, "1")) {
            arguments += reader.readAnotherElement();
        }
        else if(Objects.equals(title, "2")) {
            arguments += " " + reader.read();
            arguments += reader.readAnotherElement();
        }
        commands[commandIndex].execute(arguments);
    }

}
