package commands;

import dao.ArrayDequeDAO;
import dao.DAO;

public class DeleteCommand implements Command {
    private final DAO arrayDequeDAO;

    public DeleteCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        // если элемент есть то все ок
        //arrayDequeDAO.delete();
    }

}
