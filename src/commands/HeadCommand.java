package commands;

import dao.DAO;
import handlers.InputHandler;


/**
 * Класс команды head
 * Выводит первый элемент коллекции
 */
public class HeadCommand implements Command{
    private final DAO arrayDequeDAO;

    public HeadCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        if (arrayDequeDAO.size() != 0) {
            System.out.print("head: " + arrayDequeDAO.show() +"\n");
        } else {
            System.err.print("head: Sorry, коллекция пуста.\n");
        }
    }
}
