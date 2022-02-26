package others;

import handlers.ConsoleInputHandler;
import handlers.InputHandler;
import service.CommandManager;

public class DataBaseRunner {

    public static void main(String [] args) {
        // начинаем со считывания с консоли
        InputHandler reader = new ConsoleInputHandler();
        // запускаем менеджер-определитель команды
        CommandManager.start(reader);
    }

}
