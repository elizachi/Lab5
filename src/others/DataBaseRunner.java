package others;

import service.AskInput;
import service.CommandManager;

public class DataBaseRunner {

    public static void main(String [] args) {
        // определяем нужен ли нам дружественный интерфейс
        AskInput.turnOnFriendly();
        // считывать начинаем с консоли
        CommandManager.turnOnConsole();
        // запускаем менеджер-определитель команды
        CommandManager.start();
    }

}
