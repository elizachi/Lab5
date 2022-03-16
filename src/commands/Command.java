package commands;

import handlers.InputHandler;

public interface Command {
    void execute(InputHandler reader);
}
