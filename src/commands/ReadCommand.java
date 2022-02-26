package commands;

import dao.ArrayDequeDAO;
import dao.DAO;

public class ReadCommand implements Command {
    private final DAO arrayDequeDAO;

    public ReadCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        // если айдишка есть то все ок
        //arrayDequeDAO.read();
    }
}
