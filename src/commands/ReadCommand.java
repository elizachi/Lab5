package commands;

import dao.ArrayDequeDAO;
import dao.DAO;
import handlers.InputHandler;

import java.util.ArrayList;

/**
 * Класс команды help
 * Выводит первый элемент коллекции
 */
public class ReadCommand implements Command {
    private final DAO arrayDequeDAO;

    public ReadCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        // если айдишка есть то все ок
        //arrayDequeDAO.read();
    }
}
