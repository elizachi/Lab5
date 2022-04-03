package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды exit
 */
public class ExitCommand implements Command{

    @Override
    public void execute(InputHandler reader) {
        System.out.print("exit: Программа завершается без сохранения.");
        throw new RuntimeException();
    }
}
