package commands;

import exceptions.EndException;
import handlers.InputHandler;
import service.AskInput;
import service.CommandManager;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ScriptCommand implements Command{
    private final AskInput request = new AskInput();

    @Override
    public void execute(InputHandler reader) {
        FileInputStream usableFile;
        try {
            // считываем имя файла
            usableFile = request.askFileName(reader);
        } catch (EndException e) {
            System.err.print(e.getMessage());
            return;
        }
        // если все хорошо создаем BufferedInputStream, при помощи которого будем считывать с файла
        BufferedInputStream bufferedInput = new BufferedInputStream(usableFile);
        // меняем тип считывания на файловый
        CommandManager.turnOnFile(bufferedInput);
    }
}
