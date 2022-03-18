package commands;

import dao.DAO;
import handlers.InputHandler;

public class ReadCommand implements Command {
    private final DAO arrayDequeDAO;

    public ReadCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        System.out.print(arrayDequeDAO.toString());
    }
}
