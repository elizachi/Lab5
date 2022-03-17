package commands;

import handlers.InputHandler;
import source.HumanBeing;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс команды info
 * Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand implements Command {
    private Deque<HumanBeing> humanCollection = new ArrayDeque<>();

    InfoCommand(Deque<HumanBeing> humanCollection){
        this.humanCollection = humanCollection;
    }

    @Override
    public void execute(InputHandler reader) {
        System.out.print("info: Коллекция ArrayDeque, создана:" + "..." + "\n" + "Количество элементов: " + humanCollection.size() + "\n");
    }
}
