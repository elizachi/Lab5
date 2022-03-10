package commands;

import dao.DAO;
import handlers.InputHandler;
import service.FormedManager;

/**
 * Класс команды add. Добавляет новый элемент в коллекцию.
 */
public class AddCommand implements Command {
    private final DAO arrayDequeDAO;
    private final FormedManager manager = new FormedManager();

    public AddCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    /**
     * Обработка поступивших паратемтров и добавление их в коллекцию
     * @param reader - экземпляр класса InputHandler который определяет тип считывания
     */
    @Override
    public void execute(InputHandler reader) {
        arrayDequeDAO.add(manager.formed(reader));
    }
}
