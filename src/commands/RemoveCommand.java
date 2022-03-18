package commands;

import dao.DAO;
import exceptions.EndException;
import handlers.InputHandler;
import service.AskInput;

public class RemoveCommand implements Command {
    private final DAO arrayDequeDAO;

    public RemoveCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        int id = 0;
        try {
            id = AskInput.askId(reader);
        } catch (EndException e) {
            return;
        }
        if(arrayDequeDAO.get(id) != null) {
            arrayDequeDAO.remove(id);
            System.out.print("remove_by_id: Эхб, элемент удалили....\n");
        } else {
            System.err.print("remove_by_id: Элемента с таким id не нашлось.\n");
        }
    }
}
