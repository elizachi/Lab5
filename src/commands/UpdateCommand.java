package commands;

import dao.DAO;
import exceptions.EndException;
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
        int id = 0;
        try {
            id = AskInput.askId(reader);
        } catch (EndException e) {
            System.err.print(e.getMessage());
            return;
        }
        if(arrayDequeDAO.get(id) != null) {
            HumanBeing existedHuman;
            try {
                existedHuman = manager.formed(reader);
            } catch (EndException e) {
                System.err.print(e.getMessage());
                return;
            }
            arrayDequeDAO.update(id, existedHuman);
            System.out.print("update: Ура ура! Элемент обновлён!\n");
        } else {
            System.err.print("update: Элемента с таким id не нашлось.\n");
        }
    }
}
