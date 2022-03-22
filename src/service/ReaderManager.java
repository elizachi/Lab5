package service;

import handlers.*;

import java.io.BufferedInputStream;
import java.util.ArrayList;

/**
 * Класс обработчик, определяющий команду и ее поведение по отношению к входным данным
 */
public class ReaderManager {
    private static InputHandler reader;
    private static ArrayList<InputHandler> handlers = new ArrayList<>();


    public static InputHandler getReader() {
        return reader;
    }

    public static void removeLast() {
        handlers.remove(handlers.size() - 1);
    }
    /**
     * Меняет тип считывания на считывание с консоли
     */
    public static void turnOnConsole() {
        // новый экземпляр класса считывания
        reader = new ConsoleInputHandler();
        // добавляем в массив хендлеров, чтобы потом к нему вернуться
        handlers.add(reader);
        // Возврат к дружественному интерфейсу после считывания с файла, если оно было
        AskInput.returnFriendly();
    }

    public static void returnOnPreviousReader() {
        reader = handlers.get(handlers.size()-1);
        AskInput.returnFriendly();
    }

    /**
     * Меняет тип считывания на считывание с файла.
     * Отключает дружественный интерфейс, если он включён
     */
    public static void turnOnFile(BufferedInputStream bufferedInput) {
        reader = new FileInputHandler(bufferedInput);
        handlers.add(reader);
        AskInput.turnOffFriendly();
    }

}