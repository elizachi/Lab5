package commands;

import handlers.InputHandler;
import source.HumanBeing;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс команды head
 * Выводит первый элемент коллекции
 */
public class HeadCommand implements Command{
    private Deque<HumanBeing> humanCollection = new ArrayDeque<>();

    public HeadCommand(Deque<HumanBeing> humanCollection){
        this.humanCollection = humanCollection;
    }

    @Override
    public void execute(InputHandler reader) {
        if (!(humanCollection.isEmpty())){
            System.out.print("head: Первый элемент коллекции - " + humanCollection.getFirst() + "\n");
        } else {
            System.err.print("head: Sorry, коллекция пуста.\n");
        }
    }
}
