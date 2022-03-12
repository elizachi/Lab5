package handlers;

import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Переопределённый метод для считывания с консоли
     * @return считанная строка без лишних пробелов
     */
    @Override
    public String read() {
        // ВНИМАНИЕ!!!! Считывает не строку целиком, а просто следующее слово!!!
        // механизм пропускает остальную информацию введенною в строку, если подано false и переходит на след. строку
        String input = removeSpaces(scanner.nextLine().split(" ")[0]);
        if(input.isEmpty()) {
            throw new RuntimeException("Пустой ввод!");
        }
        return input;
    }
}
