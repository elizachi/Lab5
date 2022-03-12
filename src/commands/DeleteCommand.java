package commands;

import dao.DAO;
import handlers.InputHandler;

public class DeleteCommand implements Command {
    private final DAO arrayDequeDAO;

    public DeleteCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        // если элемент есть то все ок
        //arrayDequeDAO.delete();
    }
}
