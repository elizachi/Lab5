package commands;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> arguments);
    boolean isCorrect(ArrayList<String> arguments);
}
