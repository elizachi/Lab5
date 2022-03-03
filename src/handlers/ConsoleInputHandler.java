package handlers;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Переопределённый метод для считывания с консоли
     * @return считанная строка без лишних пробелов
     */
    @Override
    public String read(boolean is) {
        // ВНИМАНИЕ!!!! Считывает не строку целиколм, а просто следующее слово!!!
        String input;
        if(!is) scanner.nextLine();
        input = removeSpaces(scanner.next());
        if(input.isEmpty()) {
            throw new RuntimeException("Пустой ввод!");
        }
        return input;
    }
}
