package commands;

import dao.ArrayDequeDAO;
import dao.DAO;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final DAO arrayDequeDAO;

    public DeleteCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(ArrayList arguments) {
        // если элемент есть то все ок
        //arrayDequeDAO.delete();
    }


    @Override
    public boolean isCorrect(ArrayList<String> arguments) {
        return false;
    }
}
