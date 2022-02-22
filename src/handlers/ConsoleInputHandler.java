package handlers;

import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    Scanner scanner = new Scanner(System.in);
    /**
     * Переопределённый метод для считывания с консоли
     * @return считанная строка без лишних пробелов
     * @exception RuntimeException
     */
    @Override
    public String read() {
        String input = removeSpaces(scanner.nextLine());
        if(input.isEmpty()) {
            throw new RuntimeException("Пустой ввод!");
        }
        return input;
    }
}
