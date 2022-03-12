package commands;

import dao.DAO;
import handlers.InputHandler;
import service.AskInput;

public class RemoveCommand implements Command {
    private final DAO arrayDequeDAO;

    public RemoveCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        int id = AskInput.askId(reader);
        arrayDequeDAO.remove(id);
    }
}
