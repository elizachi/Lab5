package commands;

import dao.DAO;
import exceptions.EndException;
import handlers.InputHandler;
import service.AskInput;

/**
 * Класс команды remove_by_id
 * Удаляет элемент из коллекции по его id
 */
public class RemoveByIdCommand implements Command {
    private final DAO arrayDequeDAO;
    private final AskInput request = new AskInput();

    public RemoveByIdCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        int id = 0;
        try {
            id = request.askId(reader);
        } catch (EndException e) {
            System.err.print(e.getMessage());
            return;
        }
        if(arrayDequeDAO.get(id) != null) {
            arrayDequeDAO.remove(id);
            arrayDequeDAO.sort();
            System.out.print("remove_by_id: Эхб, элемент удалили....\n");
        } else {
            System.err.print("remove_by_id: Элемента с таким id не нашлось.\n");
        }
    }
}

