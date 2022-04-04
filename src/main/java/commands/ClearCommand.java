package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды clear
 * Очищает коллекцию
 */
public class ClearCommand implements Command{
    private final DAO arrayDequeDAO;

    public ClearCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        if (arrayDequeDAO.size() != 0) {
            arrayDequeDAO.clearCollection();
            System.out.print("clear: Коллекция успешно очищена.\n");
        } else {
            System.err.print("clear: Коллекция и так пуста.\n");
        }
    }
}
