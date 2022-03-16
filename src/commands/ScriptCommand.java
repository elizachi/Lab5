package commands;

import handlers.InputHandler;
import service.AskInput;
import service.CommandManager;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ScriptCommand implements Command{
    private final AskInput request = new AskInput();

    @Override
    public void execute(InputHandler reader) {
        // считываем имя файла
        FileInputStream usableFile = request.askFileName(reader);
        BufferedInputStream bufferedInput = new BufferedInputStream(usableFile);
        // меняем тип считывания на файловый
        CommandManager.turnOnFile(bufferedInput);
    }
}
