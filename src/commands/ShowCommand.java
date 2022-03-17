package commands;

import dao.DAO;
import handlers.InputHandler;
import source.HumanBeing;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс команды show
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand implements Command{
    private Deque<HumanBeing> humanCollection = new ArrayDeque<>();
    private final DAO arrayDequeDAO;

    public ShowCommand(Deque<HumanBeing> humanCollection, DAO arrayDequeDAO){
        this.humanCollection = humanCollection;
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        int id = humanCollection.getLast().getId();
        if (!(humanCollection.isEmpty())) {
            for (int i = 0; i < id; i++) {
                if (arrayDequeDAO.get(i) != null) {
                    System.out.print(arrayDequeDAO.get(i));
                }
            }
        } else {
            System.err.print("show: Коллекция пустая!\n");
        }
    }
}
