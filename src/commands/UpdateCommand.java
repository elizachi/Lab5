package commands;

import commands.Command;
import dao.ArrayDequeDAO;
import service.FormedManager;

public class UpdateCommand implements Command {
    ArrayDequeDAO arrayDequeDAO;

    public UpdateCommand(ArrayDequeDAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {
        FormedManager manager = new FormedManager();

        arrayDequeDAO.update();
    }
}
