package others;

import commands.*;
import dao.ArrayDequeDAO;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;

enum CommandType {
    ADD,
    UPDATE;
}
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

        InputHandler[] handler = {

        };

        String arguments = reader.getArguments(input);
        int commandIndex = CommandType.valueOf(command.toUpperCase()).ordinal();
        if(commandIndex < 5) {
            arguments += reader.readAnotherElement();
        }
        commands[commandIndex].execute(arguments);
    }

}
