package commands;

import dao.DAO;
import exceptions.EndException;
import handlers.InputHandler;
import service.AskInput;
import service.FormedManager;
import source.HumanBeing;

/**
 * Класс команды update id {element}
 * Обновляет значение элемента коллекции, id которого равен заданному
 */
public class UpdateCommand implements Command {
    private final DAO arrayDequeDAO;
    private final AskInput request = new AskInput();
    private final FormedManager manager = new FormedManager(request);

    public UpdateCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        int id = 0;
        try {
            id = request.askId(reader);
        } catch (EndException e) {
            System.err.print(e.getMessage());
            return;
        }
        if(arrayDequeDAO.get(id) != null) {
            HumanBeing existedHuman;
            try {
                existedHuman = manager.formed(reader);
            } catch (EndException e) {
                System.err.print(e.getMessage());
                return;
            }
            arrayDequeDAO.update(id, existedHuman);
            arrayDequeDAO.sort();
            System.out.print("update: Ура ура! Элемент обновлён!\n");
        } else {
            System.err.print("update: Элемента с таким id не нашлось.\n");
        }
    }
}

