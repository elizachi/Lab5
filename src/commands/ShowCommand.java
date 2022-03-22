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
            for (int i = 0; i < arrayDequeDAO.getAvailableId(); i++) {
                if (arrayDequeDAO.get(i) != null) {
                    System.out.print(arrayDequeDAO.get(i).toString() + "\n");
                }
            }
        }
    }
}

