package handlers;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<String> data_in = new ArrayList<>();
    /**
     * Переопределённый метод для считывания с консоли
     * @return считанная строка без лишних пробелов
     */
    @Override
    public ArrayList read() {
        String input = removeSpaces(scanner.nextLine());
        if(input.isEmpty()) {
            throw new RuntimeException("Пустой ввод!");
        }
        while (!input.isEmpty()) {
            data_in.add(input);
            input = removeSpaces(scanner.nextLine());
        }
        return data_in;
    }
}
