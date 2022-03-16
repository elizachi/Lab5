package handlers;

import java.io.*;

public class FileInputHandler extends InputHandler {
    private final BufferedInputStream bufferedInput;
    private String word = "";

    public FileInputHandler(BufferedInputStream bufferedInput) {
        this.bufferedInput = bufferedInput;
    }

    /**
     * Переопределённый метод для считывания с файла
     * @return одно слово указанного файла
     */
    @Override
    public String readInput() {
        int i;
        try {
            i = bufferedInput.read();
            while(i != -1) {
                if(i == ' ' || i == '\n') break;
                word += (char)i;
                i = bufferedInput.read();
            }
        } catch (IOException e) {
            System.err.print("Произошла ошибка.\n");
            return null;
        }
        return word;
    }
}
