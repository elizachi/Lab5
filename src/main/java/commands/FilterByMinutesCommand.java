package commands;

import dao.DAO;
import exceptions.EndException;
import handlers.InputHandler;
import service.AskInput;
import source.HumanBeing;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByMinutesCommand implements Command{
    private final DAO arrayDequeDAO;
    private final AskInput request = new AskInput();

    public FilterByMinutesCommand(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }
    @Override
    public void execute(InputHandler reader) {
        try {
            long minutes = request.askMinutesOfWaiting(reader);
            List<HumanBeing> listOfHumans = arrayDequeDAO.getAll()
                    .stream()
                    .filter(human -> human.getMinutesOfWaiting() == minutes)
                    .collect(Collectors.toList());
            if(listOfHumans.size() == 0) {
                System.err.print("Элементов не нашлось.\n");
            } else {
                for(HumanBeing element: listOfHumans) {
                    System.out.println(element.toString());
                }
            }
        } catch (EndException e) {
            System.err.print(e.getMessage());
        }
    }
}
