package commands;

import dao.DAO;
import handlers.InputHandler;
import source.HumanBeing;

import java.util.*;

public class PrintUniqueSpeed implements Command {
    private final DAO arrayDequeDAO;

    public PrintUniqueSpeed(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    @Override
    public void execute(InputHandler reader) {
        List<Integer> uniqueFieldsSpeed = new ArrayList<Integer>();
        for(HumanBeing human: arrayDequeDAO.getAll()) {
            Integer speed = human.getImpactSpeed();
            if(!uniqueFieldsSpeed.contains(speed)) {
                uniqueFieldsSpeed.add(speed);
            } else {
                uniqueFieldsSpeed.remove(speed);
            }
        }
        for(Integer element: uniqueFieldsSpeed) {
            System.out.println(element);
        }
    }
}

