package handlers;

import service.ReaderManager;

import java.io.*;

public class FileInputHandler extends InputHandler {
    private final BufferedInputStream bufferedInput;
    private static long numberOfString = 0;

    public FileInputHandler(BufferedInputStream bufferedInput) {
        this.bufferedInput = bufferedInput;
    }
    public static long getNumberOfString() {
        return numberOfString;
    }

    /**
     * Переопределённый метод для считывания с файла
     * @return одно слово указанного файла
     */
    @Override
    public String readInput() throws IOException{
        String word = "";
        int i;
            while((i = bufferedInput.read()) != -1) {
                if(i != '\n' && i != '\r') {
                    word += (char)i;
                } else if(i == '\n') break;
            } if(i == -1) {
                // автоматическое переключение на ридер на уровень ниже, т.е. на предыдущий задействованный
                ReaderManager.returnOnPreviousReader();
                ReaderManager.removeLast();
            }
        numberOfString++;
        return word.split(" ")[0];
    }
}

