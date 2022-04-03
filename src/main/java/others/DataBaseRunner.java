package others;

import service.AskInput;
import service.CommandManager;
import service.ReaderManager;

public class DataBaseRunner {

    /**
     * Главный класс
     * @param args
     */
    public static void main(String [] args) {
        try {
            // Запрос на включение дружественного интерфейса
            AskInput.turnOnFriendly();
            // Включение считывание с консоли
            ReaderManager.turnOnConsole();
            // Определение введённой команды
            CommandManager.whichCommand();
        } catch (RuntimeException e) {
            System.out.print("exit: Программа завершается без сохранения.");
        }
    }
}
