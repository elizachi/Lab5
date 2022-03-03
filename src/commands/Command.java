package commands;

import handlers.InputHandler;

import java.util.ArrayList;

public interface Command {
    void execute(InputHandler reader);
}
