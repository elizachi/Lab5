package commands;

import dao.ArrayDequeDAO;
import dao.DAO;

import java.util.ArrayList;

public class ReadCommand implements Command {
    private final DAO arrayDequeDAO;

    public ReadCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(ArrayList arguments) {
        // если айдишка есть то все ок
        //arrayDequeDAO.read();
    }

    @Override
    public boolean isCorrect(ArrayList<String> arguments) {
        return false;
    }
}
