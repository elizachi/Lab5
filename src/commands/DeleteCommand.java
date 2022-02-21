package commands;

import commands.Command;
import dao.ArrayDequeDAO;

public class DeleteCommand implements Command {
    ArrayDequeDAO arrayDequeDAO;

    public DeleteCommand(ArrayDequeDAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        // если элемент есть то все ок
        arrayDequeDAO.delete();
    }

}
