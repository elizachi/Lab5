package others;

import service.CommandManager;

public class DataBaseRunner {

    /**
     * Главный класс
     * @param args
     */
    public static void main(String [] args) {
        // считывать начинаем с консоли
        CommandManager.turnOnConsole();
        // запускаем менеджер-определитель команды
        CommandManager.whichCommand();
    }

}
