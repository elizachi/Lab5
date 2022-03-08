package others;

import handlers.ConsoleInputHandler;
import service.AskInput;
import service.CommandManager;

public class DataBaseRunner {

    public static void main(String [] args) {
        AskInput friendlyInterface = new AskInput();
        // определяем нужен ли нам дружественный интерфейс
        friendlyInterface.turnOnFriendly();
        // начинаем со считывания с консоли
        CommandManager manager = new CommandManager(new ConsoleInputHandler());
        // запускаем менеджер-определитель команды
        manager.start(true);
    }

}
