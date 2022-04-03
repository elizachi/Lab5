package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды exit
 */
public class ExitCommand implements Command{

    @Override
    public void execute(InputHandler reader) {
        throw new RuntimeException();
    }
}
