package commands;

import dao.DAO;
import handlers.InputHandler;
import source.HumanBeing;


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
    public void execute(InputHandler reader) {
        // formed(arguments);
    }
}
