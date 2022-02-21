package commands;

import commands.Command;
import dao.ArrayDequeDAO;

public class ReadCommand implements Command {
    ArrayDequeDAO arrayDequeDAO;

    public ReadCommand(ArrayDequeDAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        // если айдишка есть то все ок
        arrayDequeDAO.read();
    }
}
