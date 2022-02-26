package commands;

import dao.ArrayDequeDAO;
import dao.DAO;
import service.FormedManager;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final DAO arrayDequeDAO;

    public UpdateCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(ArrayList arguments) {

//
    }


    @Override
    public boolean isCorrect(ArrayList<String> arguments) {
        return false;
    }
}
