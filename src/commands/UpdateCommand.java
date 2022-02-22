package commands;

import dao.ArrayDequeDAO;
import service.FormedManager;

public class UpdateCommand implements Command {
    private final ArrayDequeDAO arrayDequeDAO;

    public UpdateCommand(ArrayDequeDAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(String arguments) {

        int existedId = Integer.parseInt(arguments.substring(0, arguments.indexOf(" ")));
        arguments = arguments.substring(arguments.indexOf(" ") + 1);
        FormedManager manager = new FormedManager();
        arrayDequeDAO.update(existedId, manager.formed(arguments));
    }
}
