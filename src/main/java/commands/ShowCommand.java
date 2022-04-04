package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды show
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand implements Command{
    private final DAO arrayDequeDAO;

    public ShowCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        if (arrayDequeDAO.size() == 0) {
            System.err.print("show: Коллекция пустая!\n");
        } else {
            arrayDequeDAO.sort();
            System.out.print("show: \n");
            arrayDequeDAO.getAll().forEach(System.out::println);
        }
    }
}
