package handlers;

import handlers.InputHandler;

import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    /**
     * Переопределённый метод для считывания с консоли
     * @return считанная строка без лишних пробелов
     * @exception RuntimeException
     */
    @Override
    public String read() {
        String input = new Scanner(System.in).nextLine();
        input = removeSpaces(input);
        if(input.isEmpty()) {
            throw new RuntimeException("Пустой ввод!");
        }
        return input;
    }
}
