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
 * Класс, позволяющий переключать дружественный интерфейс для быстрой тестировки
 * а также сразу обрабатывающий строку на наличие ошибок, связанных с типом данных
 */
public class AskInput {
    private static boolean friendlyInterface;
    private Boolean booleanInput;

    /**
     * Метод, позволяющй включить дружественный интерфейс
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
     * Метод, позволяющий выключить дружественный интерфейс
     */
    public static void turnOffFriendly(){
        friendlyInterface = false;
    }

    /**
     * Запрашивает ввод команды
     * @param in
     * @return
     */
    public static String askCommand(InputHandler in) {
        String command = null;
        while(command == null) {
            printMessage("Введите команду:");
            try {
                command = in.read();
                CommandType.valueOf(command.toUpperCase()).ordinal();
            } catch(IllegalArgumentException e) {
                if(!command.isEmpty()) System.err.print("Команада введена неверно. Повторите попытку.\n");
                else System.err.print("Вы ввели пустую строку. Повторите попытку\n");
                command = null;
            }
        }
        return command;
    }

    /**
     * Метды запроса и обработки полей класса HumanBeing
     * @param in - объект класса хендлеров, позволяющий считывать данные либо с консоли, либо с файла
     * @return корректное запрошенное поле класса
     */
    public static int askId(InputHandler in) {
        String input = null;
        while(input == null) {
            printMessage("Введите id: ");
            try {
                input = in.read();
                if(Integer.parseInt(input) <= 0) throw new NumberFormatException();
            } catch(NumberFormatException e) {
                if(!input.isEmpty()) System.err.print("Id введен неверно. Повторите попытку.\n");
                else System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        return Integer.parseInt(input);
    }

    public String askName(InputHandler in) {
        String input = null;
        while(input == null) {
            printMessage("Введите имя: ");
            try {
                input = in.read();
                if(input.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        return input;
    }

    public String askSoundtrackName(InputHandler in) {
        String input = null;
        while(input == null) {
            printMessage("Введите название саундтрека:");
            try {
                input = in.read();
                if(input.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        return input;
    }

    public Long askMinutesOfWaiting(InputHandler in){
        String input = null;
        while(input == null) {
            printMessage("Введите минуты ожидания: ");
            try {
                input = in.read();
                Long.parseLong(input);
            } catch(NumberFormatException e) {
                if(!input.isEmpty()) System.err.print("Поле minutesOfWaiting введено неверно. Повторите попытку.\n");
                else System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        return Long.parseLong(input);
    }

    public int askImpactSpeed(InputHandler in) {
        String input = null;
        while(input == null) {
            printMessage("Введите скорость: ");
            try {
                input = in.read();
                Integer.parseInt(input);
            } catch(NumberFormatException e) {
                if(!input.isEmpty()) System.err.print("Поле impactSpeed введено неверно. Повторите попытку.\n");
                else System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        return Integer.parseInt(input);
    }

    public Boolean askRealHero(InputHandler in) {
        String input = null;
        while(input == null) {
            printMessage("Был героем?");
            try {
                input = in.read();
                getBooleanInput(input);
            } catch(NumberFormatException e) {
                System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            } catch (IllegalArgumentException e) {
                System.err.print("Поле realHero введено неверно. Повторите попытку.\n");
                input = null;
            }
        }
        return getBooleanInput(input);
    }

    public Boolean askHasToothpick(InputHandler in) {
        String input = null;
        while(input == null) {
            printMessage("Пользовался зубочисткой?");
            try {
                input = in.read();
                getBooleanInput(input);
            } catch(NumberFormatException e) {
                System.out.print("\u001B[33mВы ввели пустую строку. Поле примет значение null.\u001B[0m\n");
                return null;
            } catch (IllegalArgumentException e) {
                System.err.print("Поле realHero введено неверно. Повторите попытку.\n");
                input = null;
            }
        }
        return getBooleanInput(input);
    }

    public Coordinates askCoordinates(InputHandler in) {
        printMessage("Для определения местоположения персонажа введите координаты.");
        String input = null;
        while(input == null) {
            printMessage("Введите координату x: ");
            try {
                input = in.read();
                Integer.parseInt(input);
            } catch(NumberFormatException e) {
                if(!input.isEmpty()) System.err.print("Координата x введена неверно. Повторите попытку.\n");
                else System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        int x = Integer.parseInt(input);
        input = null;
        while(input == null) {
            printMessage("Введите координату y: ");
            try {
                input = in.read();
                if(Float.parseFloat(input) < -188) throw new NumberFormatException();
            } catch(NumberFormatException e) {
                if(!input.isEmpty()) System.err.print("Координата y введена неверно. Повторите попытку.\n");
                else System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            }
        }
        Float y = Float.parseFloat(input);
        return new Coordinates(x, y);
    }

    public Mood askMood(InputHandler in){
        String input = null;
        while(input == null) {
            printMessage("Введите состояние персонажа: ");
            try {
                input = in.read();
                if(input.isEmpty()) throw new NumberFormatException();
                Mood.valueOf(input.toUpperCase());
            } catch(NumberFormatException e) {
                System.out.print("\u001B[33mВы ввели пустую строку. Поле примет значение null.\u001B[0m\n");
                return null;
            } catch (IllegalArgumentException e) {
                System.err.print("Поле mood введено неверно. Повторите попытку.\n");
                input = null;
            }
        }
        return Mood.valueOf(input.toUpperCase());
    }

    public Car askCar(InputHandler in){
        printMessage("Введите машину, принадлежащую персонажу.");
        String input = null;
        String name = null;
        while(input == null) {
            printMessage("Введите её название: ");
            try {
                input = in.read();
                name = input;
                if(input.isEmpty()) throw new IllegalArgumentException();
            } catch(IllegalArgumentException e) {
                System.out.print("\u001B[33mВы ввели пустую строку. Поле примет значение null.\u001B[0m\n");
                name = null;
            }
        }
        input = null;
        while(input == null) {
            printMessage("Машина была крутой? ");
            try {
                input = in.read();
                getBooleanInput(input);
            } catch(NumberFormatException e) {
                System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                input = null;
            } catch (IllegalArgumentException e) {
                System.err.print("Поле cool введено неверно. Повторите попытку.\n");
                input = null;
            }
        }
        boolean cool = getBooleanInput(input);
        return new Car(name, cool);
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
    private static Boolean getBooleanInput(String input) {
        input = input.toLowerCase();
        if (input.equals("true") || input.equals("yes") || input.equals("да")) {
            return true;
        } else if (input.equals("false") || input.equals("no") || input.equals("нет")) {
            return false;
        } else if (!input.isEmpty()) throw new IllegalArgumentException();
        else throw new NumberFormatException();
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
