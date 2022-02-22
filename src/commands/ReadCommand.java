package commands;

import dao.ArrayDequeDAO;

public class ReadCommand implements Command {
    private final ArrayDequeDAO arrayDequeDAO;

    public ReadCommand(ArrayDequeDAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        // если айдишка есть то все ок
        arrayDequeDAO.read();
    }
}
