package service;

import handlers.ConsoleInputHandler;
import handlers.FileInputHandler;


public class AskInput {
    private static boolean friendlyInterface;
    ConsoleInputHandler consoleInput = new ConsoleInputHandler();
    FileInputHandler fileInput = new FileInputHandler();

    public void turnOnFriendly() throws RuntimeException {
        System.out.println("Включить дружелюбный интерфейс?");
        String input = consoleInput.read();
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

    public String askName() throws RuntimeException {
        if (friendlyInterface) {
            System.out.println("Введите имя: ");
        }
        String input = consoleInput.read();
        try {
            if (input == null) {
                throw new RuntimeException("Строка не может быть пустой");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            askName();
        }
        return input;
    }

    public String askCoordinates() throws RuntimeException {
        if (friendlyInterface) {
            System.out.println("Введите координаты: ");
        }
        String input = consoleInput.read();
        try {
            if (input == null) {
                throw new RuntimeException("Строка не может быть пустой");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            askName();
        }
        return input;
    }


}
