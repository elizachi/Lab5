package others;

import handlers.ConsoleInputHandler;
import service.CommandManager;

public class DataBaseRunner {

    public static void main(String [] args) {
        // начинаем со считывания с консоли
        CommandManager manager = new CommandManager(new ConsoleInputHandler());
        // запускаем менеджер-определитель команды
        manager.start(true);
    }

}
