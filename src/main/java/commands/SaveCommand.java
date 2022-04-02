package commands;

import dao.DAO;
import handlers.InputHandler;

/**
 * Класс команды save
 */
public class SaveCommand implements Command{
    private final DAO arrayDequeDAO;

    public SaveCommand(DAO arrayDequeDAO){
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        arrayDequeDAO.save();
        System.out.print("save: Коллекция успешно загружена.\n");
    }
}
