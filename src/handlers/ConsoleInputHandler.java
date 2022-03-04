package handlers;

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
        // механизм пропускает остальную информацию введенною в строку, если подано false и переходит на след. строку
        if(!is) scanner.nextLine();
        String input = removeSpaces(scanner.next());
        if(input.isEmpty()) {
            throw new RuntimeException("Пустой ввод!");
        }
        return input;
    }
}
