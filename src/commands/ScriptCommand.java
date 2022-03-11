package commands;

import handlers.InputHandler;
import service.AskInput;
import service.CommandManager;

public class ScriptCommand implements Command{
    private final AskInput request = new AskInput();

    @Override
    public void execute(InputHandler reader) {
        // считываем имя файла
        String usableFile = request.askFileName(reader);
        // меняем тип считывания на файловый
        CommandManager.turnOnFile();
    }
}
