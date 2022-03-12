package commands;

import dao.DAO;
import handlers.InputHandler;
import service.AskInput;
import service.FormedManager;
import source.HumanBeing;

public class UpdateCommand implements Command {
    private final DAO arrayDequeDAO;
    private final FormedManager manager = new FormedManager();

    public UpdateCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        int id = AskInput.askId(reader);
        HumanBeing existedHuman = manager.formed(reader);
        arrayDequeDAO.update(id, existedHuman);
    }
}
