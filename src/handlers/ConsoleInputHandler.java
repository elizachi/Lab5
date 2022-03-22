package handlers;

import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Переопределённый метод для считывания с консоли
     * @return считанная строка без лишних пробелов
     */
    @Override
    public String readInput() {
        // ВНИМАНИЕ!!!! Считывает только первое слово введённой строки. Остальные данные игнорируются.
        String input = scanner.nextLine().trim().split(" ")[0];
        return input;
    }
}

