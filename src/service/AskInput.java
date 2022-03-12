package service;

import handlers.ConsoleInputHandler;
import handlers.InputHandler;
import source.Car;
import source.Coordinates;
import source.Mood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

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
        String input = inputHandler.read().toLowerCase();
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

    public static String askCommand(InputHandler in) {
        String command = null;
        while(command == null) {
            printMessage("Введите команду:\n");
            command = in.read();
            try {
                CommandType.valueOf(command.toUpperCase()).ordinal();
            } catch(IllegalArgumentException e) {
                System.err.print("Команада введена неверно. Повторите попытку.\n");
                command = null;
            }
        }
        return command;
    }

    public static int askId(InputHandler in) {
        printMessage("Введите id: ");
        return Integer.parseInt(in.read());
    }
    /**
     * Метод, запрашивающий ввод поля "name"
     * @param in
     * @return
     */
    public String askName(InputHandler in) {
        printMessage("Введите имя: ");
        return in.read();
    }

    /**
     * Методы по полям класса HumanBeing для их считывания
     * @return возвращает введенную строку
     * @throws RuntimeException если неверно введены координаты
     */
    public Coordinates askCoordinates(InputHandler in) throws RuntimeException {
        printMessage("Введите координаты: ");
        String input_x = in.read();
        String input_y = in.read();
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
        String input = in.read();
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
        String input = in.read();
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
        String input = in.read();
        return Integer.parseInt(input);
    }

    public String askSoundtrackName(InputHandler in) throws RuntimeException {
        printMessage("Введите название саундтрека:");
        return in.read();
    }

    public Long askMinutesOfWaiting(InputHandler in){
        printMessage("Введите минуты ожидания:");
        String input = in.read();
        return Long.getLong(input);
    }

    public Mood askMood(InputHandler in){
        printMessage("Введите состояние персонажа:");
        String string = in.read().toUpperCase();
        return Mood.valueOf(string);
    }

    public Car askCar(InputHandler in){
        printMessage("Введите, какая машина будет у данного персонажа:");
        String input_name = in.read();
        String input_cool = in.read();
        return new Car(input_name, Boolean.parseBoolean(input_cool));
    }

    public String askFileName(InputHandler in) {
        String fileName = in.read();
        File file = new File(fileName);
        try {
            if(!file.exists()) throw new FileNotFoundException("Файл не найден.\n");
            if(file.length() == 0) throw new NoSuchElementException("Файл пуст.\n");
            if(!file.canRead()) throw new IOException("Нет прав на чтение.\n");
        } catch(NoSuchElementException | IOException e) {
            System.err.print(e.getMessage());
        }
        return fileName;
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
    private static void printMessage(String message){
        if (friendlyInterface) {
            System.out.println(message);
        }
    }
}
