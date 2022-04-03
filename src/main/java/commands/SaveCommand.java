package commands;

import dao.DAO;
import handlers.InputHandler;

import java.io.IOException;

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
        try {
            arrayDequeDAO.save();
            System.out.print("save: Коллекция успешно загружена.\n");
        } catch (IOException e) {
            System.err.print("save: Коллекцию не удалось загрузить в файл.\n");
        }
    }
}
