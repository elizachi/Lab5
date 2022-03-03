package commands;

import dao.ArrayDequeDAO;
import dao.DAO;
import handlers.InputHandler;
import service.FormedManager;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final DAO arrayDequeDAO;

    public UpdateCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
//
    }
}
