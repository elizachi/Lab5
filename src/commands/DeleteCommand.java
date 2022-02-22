package commands;

import dao.ArrayDequeDAO;

public class DeleteCommand implements Command {
    private final ArrayDequeDAO arrayDequeDAO;

    public DeleteCommand(ArrayDequeDAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        // если элемент есть то все ок
        arrayDequeDAO.delete();
    }

}
