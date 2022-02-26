package commands;

import dao.ArrayDequeDAO;
import dao.DAO;
import source.HumanBeing;
import service.FormedManager;

/**
 * ЗДЕСЬ БУДЕТ ПОЛНАЯ ОБРАБОТКА ВХОДНЫХ ДАННЫХ С ФОРМИРОВАНИЕМ ЭЛЕМЕНТОВ
 */
public class AddCommand implements Command {
    private final DAO arrayDequeDAO;

    public AddCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    /**
     * Обработка поступивших паратемтров и добавление их в коллекцию
     * @param arguments - все аргументы, нужные для формирования аргумента, в виде строки
     */
    @Override
    public void execute(String arguments) {
        // Создаю экземпляр класса формирователя
        FormedManager manager = new FormedManager();
        // Новый экземпляр класса human_being.HumanBeing
        HumanBeing newHuman = manager.formed(arguments);
        // Добавление экземпляра класса в коллекцию
        arrayDequeDAO.add(newHuman);
    }
}
