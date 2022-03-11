package service;

import handlers.ConsoleInputHandler;
import handlers.InputHandler;
import source.Car;
import source.Coordinates;
import source.Mood;

import java.util.Locale;

/**
 * Класс, позволяющий переключать дружелюбный интерфейс для быстрой отладки
 * а также сразу обрабатывающий строку на наличие ошибок
 */
public class AskInput {
    private static boolean friendlyInterface;
    private Boolean booleanInput;

    /**
     * Метод, позволяющй включить дружелюбный интерфейс
     * @throws RuntimeException
     */
    public static void turnOnFriendly() throws RuntimeException {
        InputHandler inputHandler = new ConsoleInputHandler();
        System.out.println("Включить дружелюбный интерфейс?");
        String input = inputHandler.read(false).toLowerCase();
        try {
            if (input.equals("true") || input.equals("yes") || input.equals("да")) {
                friendlyInterface = true;
            } else if (input.equals("false") || input.equals("no") || input.equals("нет")) {
                friendlyInterface = false;
            } else {
                throw new RuntimeException("Вы что-то не то ввели, пожалуйста, повторите попытку.\n" +
                        "Вы можете ввести следующее: \"да\" \"yes\" \"true\" \"нет\" \"no\" \"false\"\n\n");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            turnOnFriendly();
        }
    }

    /**
     * Метод, позволяющий выключить дружелюбный интерфейс
     */
    public static void turnOffFriendly(){
        friendlyInterface = false;
    }

    public String askName(InputHandler in) {
        printMessage("Введите имя: ");
        return in.read(false);
    }

    /**
     * Методы по полям класса HumanBeing для их считывания
     * @return возвращает введенную строку
     * @throws RuntimeException если неверно введены координаты
     */
    public Coordinates askCoordinates(InputHandler in) throws RuntimeException {
        printMessage("Введите координаты: ");
        String input_x = in.read(true);
        String input_y = in.read(false);
        int x = 0;
        float y = 0;
        try {
            x = Integer.parseInt(input_x);
            y = Float.parseFloat(input_y);
        } catch (RuntimeException e) {
            if (friendlyInterface) {
                System.out.println(e.getMessage());
                askCoordinates(in);
            }
        }
        return new Coordinates(x, y);
    }

    public Boolean askRealHero(InputHandler in) throws RuntimeException {
        printMessage("Является ли этот человек настоящим героем?");
        String input = in.read(false);
        input = input.toLowerCase();
        try {
            if (input.contains("true") || input.contains("yes") || input.contains("да")) {
                booleanInput = true;
            } else if (input.contains("false") || input.contains("no") || input.contains("нет") || input.equals("")) {
                booleanInput = false;
            } else {
                throw new RuntimeException("Нераспознаваемые символы.");
            }
        } catch (RuntimeException e){
            if (friendlyInterface){
                System.out.println(e.getMessage());
                askRealHero(in);
            }
        }
        return booleanInput;
    }

    @SuppressWarnings("DuplicatedCode")
    public Boolean askHasToothpick(InputHandler in) throws RuntimeException {
        printMessage("Есть ли у человека зубная щётка?");
        String input = in.read(false);
        try {
            booleanInput = getBooleanInput(input);
        } catch (RuntimeException e){
            if (friendlyInterface){
                System.out.println(e.getMessage());
                askRealHero(in);
            }
        }
        return booleanInput;
    }

    public int askImpactSpeed(InputHandler in) {
        printMessage("Введите скорость:");
        String input = in.read(false);
        return Integer.parseInt(input);
    }

    public String askSoundtrackName(InputHandler in) throws RuntimeException {
        printMessage("Введите название саундтрека:");
        return in.read(false);
    }

    public Long askMinutesOfWaiting(InputHandler in){
        printMessage("Введите минуты ожидания:");
        String input = in.read(false);
        return Long.getLong(input);
    }

    public Mood askMood(InputHandler in){
        printMessage("Введите состояние персонажа:");
        String string = in.read(false).toUpperCase();
        return Mood.valueOf(string);
    }

    public Car askCar(InputHandler in){
        printMessage("Введите, какая машина будет у данного персонажа:");
        String input_name = in.read(true);
        String input_cool = in.read(false);
        return new Car(input_name, Boolean.parseBoolean(input_cool));
    }

    /**
     * Внутренний метод для более удобного преобразования String в Boolean
     * @param input строка, которая будет преобразовываться в Boolean
     * @return true (если в строке присутствует true, yes, да вне зависимости от регистра), false (если в строке присутствует false, no, нет или если строка пустая)
     */
    private Boolean getBooleanInput(String input) {
        input = input.toLowerCase();
        if (input.contains("true") || input.contains("yes") || input.contains("да")) {
            return true;
        } else if (input.contains("false") || input.contains("no") || input.contains("нет") || input.equals("")) {
            return false;
        } else throw new RuntimeException("Нераспознаваемые символы.");
    }
    /**
     * Внутренний метод для вывода сообщения относительно friendlyInterface
     * @param message строка, которая будет напечатана, если дружественный интерфейс включен
     */
    private void printMessage(String message){
        if (friendlyInterface) {
            System.out.println(message);
        }
    }
}
