package commands;

import handlers.InputHandler;
import source.HumanBeing;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс команды clear
 * Очищает коллекцию
 */
public class ClearCommand implements Command{
    private Deque<HumanBeing> humanCollection = new ArrayDeque<>();

    public ClearCommand(Deque<HumanBeing> humanCollection){
        this.humanCollection = humanCollection;
    }

    @Override
    public void execute(InputHandler reader) {
        if (!(humanCollection.isEmpty())){
            humanCollection.clear();
            System.out.print("clear: Коллекция очищена!\n");
        } else {
            System.err.print("clear: Коллекция и так пуста.\n");
        }
    }
}
