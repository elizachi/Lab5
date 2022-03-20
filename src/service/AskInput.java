package service;

import exceptions.EndException;
import handlers.ConsoleInputHandler;
import handlers.InputHandler;
import source.Car;
import source.Coordinates;
import source.Mood;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Класс, позволяющий переключать дружественный интерфейс для быстрой тестировки
 * а также сразу обрабатывающий строку на наличие ошибок, связанных с типом данных
 */
public class AskInput {
    private static boolean CONST_FRIENDLY_INTERFACE;
    private static boolean friendlyInterface;

    /**
     * Метод, позволяющй включить дружественный интерфейс
     */
    public static void turnOnFriendly() {
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        System.out.println("Включить дружественный интерфейс?");
        String input = inputHandler.readInput().toLowerCase();
        try {
            CONST_FRIENDLY_INTERFACE = getBooleanInput(input);
        } catch(NumberFormatException e) {
            System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
            turnOnFriendly();
        } catch (IllegalArgumentException e) {
            System.err.print("Программа не понимает вашего ответа. Повторите попытку.\n");
            turnOnFriendly();
        }
    }

    /**
     * Метод, позволяющий выключить дружественный интерфейс
     */
    public static void turnOffFriendly() {
        friendlyInterface = false;
    }

    public static void returnFriendly() {
        friendlyInterface = CONST_FRIENDLY_INTERFACE;
    }
    /**
     * Запрашивает ввод команды
     * @param in
     * @return
     */
    public static String askCommand(InputHandler in) throws EndException{
        String command = null;
        while(command == null) {
            printMessage("Введите команду:");
            try {
                command = in.readInput();
                CommandType.valueOf(command.toUpperCase()).ordinal();
            } catch(IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    if(!command.isEmpty()) {
                        System.err.print("Команада введена неверно. Повторите попытку.\n");
                    } else {
                        System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    }
                    command = null;
                } else {
                    throw new EndException("Команду невозможно распознать, она будет проигнорирована.\n");
                }
            } catch (IOException e) {
                CommandManager.turnOnConsole();
                throw new EndException("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
            }
        }
        return command;
    }

    /**
     * Метды запроса и обработки полей класса HumanBeing
     * @param in - объект класса хендлеров, позволяющий считывать данные либо с консоли, либо с файла
     * @return корректное запрошенное поле класса
     */
    public static int askId(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Введите id: ");
            try {
                input = in.readInput();
                if(Integer.parseInt(input) <= 0) throw new NumberFormatException();
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    if(!input.isEmpty()) {
                        System.err.print("Id введен неверно. Повторите попытку.\n");
                    } else {
                        System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    }
                    input = null;
                } else {
                    throw new EndException("Id введен неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                CommandManager.turnOnConsole();
                throw new EndException("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
            }
        }
        return Integer.parseInt(input);
    }

    public String askName(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Введите имя: ");
            try {
                input = in.readInput();
                if(input.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле name введено неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return input;
    }

    public String askSoundtrackName(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Введите название саундтрека:");
            try {
                input = in.readInput();
                if(input.isEmpty()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле soundtrackName введено неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return input;
    }

    public Long askMinutesOfWaiting(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Введите минуты ожидания: ");
            try {
                input = in.readInput();
                Long.parseLong(input);
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    if(!input.isEmpty()) {
                        System.err.print("Поле minutesOfWaiting введено неверно. Повторите попытку.\n");
                    }
                    else {
                        System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    }
                    input = null;
                } else {
                    throw new EndException("Поле minutesOfWaiting введено неверно. Команада будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return Long.parseLong(input);
    }

    public int askImpactSpeed(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Введите скорость: ");
            try {
                input = in.readInput();
                Integer.parseInt(input);
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    if(!input.isEmpty()) {
                        System.err.print("Поле impactSpeed введено неверно. Повторите попытку.\n");
                    } else {
                        System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    }
                    input = null;
                } else {
                    throw new EndException("Поле impactSpeed введено неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return Integer.parseInt(input);
    }

    public Boolean askRealHero(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Был героем?");
            try {
                input = in.readInput();
                getBooleanInput(input);
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле realHero введено неверно. Команада будет проигнорирована.\n");
                }
            } catch (IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Поле realHero введено неверно. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле realHero введено неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return getBooleanInput(input);
    }

    public Boolean askHasToothpick(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Пользовался зубочисткой?");
            try {
                input = in.readInput();
                getBooleanInput(input);
            } catch(NumberFormatException e) {
                printMessage("\u001B[33mВы ввели пустую строку. Поле примет значение null.\u001B[0m");
                return null;
            } catch (IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Поле hasToothpick введено неверно. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле hasToothpick введено неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return getBooleanInput(input);
    }

    public Coordinates askCoordinates(InputHandler in) throws EndException{
        printMessage("Для определения местоположения персонажа введите координаты.");
        String input = null;
        while(input == null) {
            printMessage("Введите координату x: ");
            try {
                input = in.readInput();
                Integer.parseInt(input);
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    if(!input.isEmpty()) {
                        System.err.print("Координата x введена неверно. Повторите попытку.\n");
                    } else {
                        System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    }
                    input = null;
                } else {
                    throw new EndException("Координата x введена неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        int x = Integer.parseInt(input);
        input = null;
        while(input == null) {
            printMessage("Введите координату y: ");
            try {
                input = in.readInput();
                if(Float.parseFloat(input) < -188) throw new NumberFormatException();
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    if(!input.isEmpty()) {
                        System.err.print("Координата y введена неверно. Повторите попытку.\n");
                    } else {
                        System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    }
                    input = null;
                } else {
                    throw new EndException("Координата y введена неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        Float y = Float.parseFloat(input);
        return new Coordinates(x, y);
    }

    public Mood askMood(InputHandler in) throws EndException{
        String input = null;
        while(input == null) {
            printMessage("Введите состояние персонажа: ");
            try {
                input = in.readInput();
                if(input.isEmpty()) throw new NumberFormatException();
                Mood.valueOf(input.toUpperCase());
            } catch(NumberFormatException e) {
                printMessage("\u001B[33mВы ввели пустую строку. Поле примет значение null.\u001B[0m");
                return null;
            } catch (IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Поле mood введено неверно. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле mood введено неверно. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        return Mood.valueOf(input.toUpperCase());
    }

    public Car askCar(InputHandler in) throws EndException{
        printMessage("Введите машину, принадлежащую персонажу.");
        String input = null;
        String name = null;
        while(input == null) {
            printMessage("Введите её название: ");
            try {
                input = in.readInput();
                name = input;
                if(input.isEmpty()) throw new IllegalArgumentException();
            } catch(IllegalArgumentException e) {
                printMessage("\u001B[33mВы ввели пустую строку. Поле примет значение null.\u001B[0m");
                name = null;
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        input = null;
        while(input == null) {
            printMessage("Машина была крутой? ");
            try {
                input = in.readInput();
                getBooleanInput(input);
            } catch(NumberFormatException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Вы ввели пустую строку. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле cool введено неверно. Команада будет проигнорирована.\n");
                }
            } catch (IllegalArgumentException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    System.err.print("Поле cool введено неверно. Повторите попытку.\n");
                    input = null;
                } else {
                    throw new EndException("Поле cool введено неверно. Команада будет проигнорирована.\n");
                }
            } catch (IOException e) {
                System.err.print("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
                CommandManager.turnOnConsole();
            }
        }
        boolean cool = getBooleanInput(input);
        return new Car(name, cool);
    }

    public FileInputStream askFileName(InputHandler in) throws EndException{
        FileInputStream fileInput = null;
        while(fileInput == null) {
            printMessage("Введите путь до файла, который хотите прочесть.");
            try {
                String fileName = in.readInput();
                fileInput = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                if(friendlyInterface && in.getClass() == ConsoleInputHandler.class) {
                    printMessage("Файл не найден. Проверьте корректность указанного пути и повторите попытку.\n");
                    fileInput = null;
                } else {
                    throw new EndException("Файл не найден. Команда будет проигнорирована.\n");
                }
            } catch (IOException e) {
                CommandManager.turnOnConsole();
                throw new EndException("Произошла ошибка, невозможно прочитать данные из файла. " +
                        "Пожалуйста, работайте с консолью.\n");
            }
        }
        return fileInput;
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
