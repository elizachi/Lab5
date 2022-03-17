package commands;

import handlers.InputHandler;
import source.HumanBeing;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс команды help
 * Выводит первый элемент коллекции и удалить его
 */
public class RemoveHeadCommand implements Command{
    private Deque<HumanBeing> humanCollection = new ArrayDeque<>();

    public RemoveHeadCommand(Deque<HumanBeing> humanCollection){
        this.humanCollection = humanCollection;
    }

    @Override
    public void execute(InputHandler reader) {
        if (!(humanCollection.isEmpty())){
            System.out.print("remove_head: Первый элемент коллекции - " + humanCollection.removeFirst() + "\n");
        } else {
            System.err.print("remove_head: Sorry, коллекция пуста.\n");
        }
    }
}
