package commands;

import dao.DAO;
import exceptions.EndException;
import handlers.InputHandler;
import service.FormedManager;
import source.HumanBeing;

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
        HumanBeing existedHuman = null;
        try {
            existedHuman = manager.formed(reader);
        } catch (EndException e) {
            System.err.print(e.getMessage());
            return;
        }
        arrayDequeDAO.add(existedHuman);
        System.out.print("add: Ура Ура! Элемент добавлен в коллекцию!\n");
    }
}
