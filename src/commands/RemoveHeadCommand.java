package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды help
 * Выводит первый элемент коллекции и удалить его
 */
public class RemoveHeadCommand implements Command{
    private final DAO arrayDequeDAO;

    public RemoveHeadCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        if (arrayDequeDAO.size() != 0) {
            System.out.print("remove_head: элемент " + arrayDequeDAO.show() + " успешно удалён!\n");
            arrayDequeDAO.remove(arrayDequeDAO.show().getId());
            arrayDequeDAO.sort();
        } else {
            System.err.print("remove_head: Sorry, коллекция пуста.\n");
        }
    }
}
