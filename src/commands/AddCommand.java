package commands;

import dao.ArrayDequeDAO;
import dao.DAO;
import source.Car;
import source.Coordinates;
import source.HumanBeing;
import service.FormedManager;
import source.Mood;

import java.util.ArrayList;

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
    public void execute(ArrayList<String> arguments) {
        formed(arguments);
    }

    @Override
    public boolean isCorrect(ArrayList<String> arguments) {
        return formed(arguments) != null;
    }

    public HumanBeing formed(ArrayList<String> arguments) {
        if(arguments.size() < 9) {
            System.out.print("Недостаточно введенных данных. Вызываю HumanAsker.");
            // TODO здесь будет вызов нового класса HumanAsker который будет запрашивать пользовательский ввод
            //  и записывать его в массив аргументов, который у нас уже есть
            return null;
        }
        try {
            int first = Integer.parseInt(arguments.get(6).split(" ")[0]);
            float second = Float.parseFloat(arguments.get(6).split(" ")[1]);
            String carName = null;
            boolean cool;
            if(arguments.get(8).split(" ").length == 2) {
                carName = arguments.get(8).split(" ")[0];
                cool = Boolean.parseBoolean(arguments.get(8).split(" ")[1]);
            } else {
                cool = Boolean.parseBoolean(arguments.get(8).split(" ")[0]);
            }
            return new HumanBeing(
                    arguments.get(0),
                    arguments.get(1),
                    Long.parseLong(arguments.get(2)),
                    Integer.parseInt(arguments.get(3)),
                    Boolean.parseBoolean(arguments.get(4)),
                    Boolean.parseBoolean(arguments.get(5)),
                    new Coordinates(first, second),
                    Mood.valueOf(arguments.get(7).toUpperCase()),
                    new Car(carName, cool)
            );
        } catch (IllegalArgumentException e) {
            System.err.print("Неверный ввод данных! Попробуйте ввести команду add с самого начала.\n");
        }
        return null;
    }
}
