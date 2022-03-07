package service;

import handlers.InputHandler;
import source.Car;
import source.Mood;

/**
 * Класс, позволяющий переключать дружелюбный интерфейс для быстрой отладки
 * а также сразу обрабатывающий строку на наличие ошибок
 */
public class AskInput {
    private static boolean friendlyInterface;
    private InputHandler inputHandler;
    private Boolean booleanInput;

    public AskInput(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void setInputHandler(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    /**
     * Метод, позволяющй включить дружелюбный интерфейс
     * @throws RuntimeException
     */
    public void turnOnFriendly() throws RuntimeException {
        System.out.println("Включить дружелюбный интерфейс?");
        String input = inputHandler.read(true);
        input = input.toLowerCase();
        try {
            if (input.equals("true") || input.equals("yes") || input.equals("да")) {
                friendlyInterface = true;
            } else if (input.equals("false") || input.equals("no") || input.equals("нет")) {
                friendlyInterface = false;
            } else {
                throw new RuntimeException("Вы что-то не то ввели, пожалуйста, повторите попытку.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            turnOnFriendly();
        }
    }

    /**
     * Метод, позволяющий выключить дружелюбный интерфейс
     */
    public void turnOffFriendly(){
        friendlyInterface = false;
    }

    public String askName() {
        printMessage("Введите имя: ");
        return inputHandler.read(true);
    }

    /**
     * Методы по полям класса HumanBeing для их считывания
     * @return возвращает введенную строку
     * @throws RuntimeException если неверно введены координаты
     */
    public String askCoordinates() throws RuntimeException {
        printMessage("Введите координаты: ");
        String input = inputHandler.read(true);
        try {
            if (!(input.contains(" "))) {
                throw new RuntimeException("Пожалуйста, введите координаты через пробел.");
            }
            int x = Integer.parseInt(input.substring(0, input.indexOf(" ")));
            Float y = Float.parseFloat(input);
        } catch (RuntimeException e) {
            if (friendlyInterface) {
                System.out.println(e.getMessage());
                askCoordinates();
            }
        }
        return input;
    }

    public Boolean askRealHero() throws RuntimeException {
        printMessage("Является ли этот человек настоящим героем?");
        String input = inputHandler.read(true);
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
                askRealHero();
            }
        }
        return booleanInput;
    }

    @SuppressWarnings("DuplicatedCode")
    public Boolean askHasToothpick() throws RuntimeException {
        printMessage("Есть ли у человека зубная щётка?");
        String input = inputHandler.read(true);
        try {
            booleanInput = getBooleanInput(input);
        } catch (RuntimeException e){
            if (friendlyInterface){
                System.out.println(e.getMessage());
                askRealHero();
            }
        }
        return booleanInput;
    }

    public int askImpactSpeed() {
        printMessage("Введите скорость:");
        String input = inputHandler.read(true);
        return Integer.parseInt(input);
    }

    public String askSoundtrackName() throws RuntimeException {
        printMessage("Введите название саундтрека:");
        return inputHandler.read(true);
    }

    public Long askMinutesOfWaiting(){
        printMessage("Введите минуты ожидания:");
        String input = inputHandler.read(true);
        return Long.getLong(input);
    }

    public Mood askMood(){
        printMessage("Введите состояние персонажа:");
        String string = inputHandler.read(true).toUpperCase();
        return Mood.valueOf(string);
    }

    public Car askCar(){
        printMessage("Введите, какая машина будет у данного персонажа:");
        String input = inputHandler.read(true);
        Car car = new Car(false);
        if (input.contains(" ")) {
            String name = input.substring(0, input.indexOf(" "));
            car.setCarName(name);
        } else {
            Boolean cool = getBooleanInput(input);
            car.setCarCool(cool);
        }
        return car;
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
