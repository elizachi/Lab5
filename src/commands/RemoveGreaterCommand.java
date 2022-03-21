package commands;

import dao.DAO;
import exceptions.EndException;
import handlers.InputHandler;
import service.AskInput;
import service.FormedManager;
import source.HumanBeing;

import java.util.Iterator;

public class RemoveGreaterCommand implements Command{
    private final DAO arrayDequeDAO;
    private final AskInput request = new AskInput();
    private final FormedManager manager = new FormedManager(request);

    public RemoveGreaterCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        HumanBeing simpleHuman = null;
        try {
            simpleHuman = manager.formed(reader);
        } catch (EndException e) {
            System.err.print(e.getMessage());
            return;
        }
        boolean flag = false;
        if(!arrayDequeDAO.getAll().contains(simpleHuman)) {
            arrayDequeDAO.add(simpleHuman);
            flag = true;
        }
        boolean anotherFlag = false;
        Iterator<HumanBeing> iter = arrayDequeDAO.getAll().stream().iterator();
        HumanBeing nowHuman = null;
        while(iter.hasNext()) {
            if(simpleHuman.equals(nowHuman)) {
                anotherFlag = true;
            }
            if(anotherFlag) {
                if(flag) {
                    arrayDequeDAO.getAll().remove(nowHuman);
                }
                flag = false;
            }
            nowHuman = iter.next();
        }
        System.out.print("Элементы, большие заданного, успешно удалены!\n");
    }
}
