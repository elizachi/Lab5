package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды exit
 */
public class ExitCommand implements Command{
    private final DAO arrayDequeDAO;

    public ExitCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {

    }
}
