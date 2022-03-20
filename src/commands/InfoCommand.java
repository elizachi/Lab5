package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды info
 * Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand implements Command {
    private final DAO arrayDequeDAO;

    public InfoCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        System.out.print("info: Коллекция ArrayDeque, создана: " + "..." + "\n" + "Количество элементов: " + arrayDequeDAO.size() + "\n");
    }
}
