package commands;

import handlers.InputHandler;

public class HelpCommand implements Command{

    @Override
    public void execute(InputHandler reader) {
        System.out.print("""
                Доступные команды:
                help - вывести справку по доступным командам
                info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} - добавить новый элемент в коллекцию
                update id {element} - обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id - удалить элемент из коллекции по его id
                clear - очистить коллекцию
                save - сохранить коллекцию в файл
                execute_script file_name - считать и исполнить скрипт из указанного файла
                exit - завершить программу (без сохранения в файл)
                head - вывести первый элемент коллекции
                remove_head - вывести первый элемент коллекции и удалить его
                remove_greater {element} - удалить из коллекции все элементы, превышающие заданный
                filter_by_minutes_of_waiting minutesOfWaiting - вывести элементы, значение поля minutesOfWaiting которых равно заданному
                filter_greater_than_impact_speed impactSpeed - вывести элементы, значение поля impactSpeed которых больше заданного
                print_unique_impact_speed - вывести уникальные значения поля impactSpeed всех элементов в коллекции
                
                """);
    }
}
