package others;

import service.AskInput;
import service.CommandManager;

public class DataBaseRunner {

    /**
     * Главный класс
     * @param args
     */
    public static void main(String [] args) {
        // Запрос на включение дружественного интерфейса
        AskInput.turnOnFriendly();
        // Включение считывание с консоли
        CommandManager.turnOnConsole();
        // Определение введённой команды
        CommandManager.whichCommand();
    }

}
