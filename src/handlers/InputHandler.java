package handlers;

import java.util.ArrayList;
import java.util.List;

public abstract class InputHandler {
    /**
     * Абстрактный метод read, переопределяемый для двух разных типов считывания - с консоли и с файла
     */
    public abstract String read();
    /**
     *Убирает лишние пробелы из полученной строки для дальнейшей обработки
     * @param input  - только что введённая строка
     * @return       - строка без лишних пробелов
     */
    public String removeSpaces(String input) {
        input = input.trim();
        while(input.contains("  ")) {
            input = input.replace("  ", " ");
        }
        return input;
    }

    // вырезаем первое слово из общей строки
    public static String getFirstWord(String input) {
        if(input.contains(" ")) {
            return input.substring(0, input.indexOf(" "));
        }
        return input;
    }

    /**
     * Считывает оставшиеся элементы
     * @return
     */
    public String readAnotherElement() {
        System.out.print("Введите координаты:\n");
        String coord = read();
        System.out.print("Введите состояние персонажа:\n");
        String mood = read();
        System.out.print("Введите машину персонажа:\n");
        String car = read();
        return " " + coord + " " + mood + " " + car;
    }

    /**
     * Обрезка строки без первого слова для дальнейшей работы
     * @param input - строка, подающаяся на вход
     * @return обрезанная строка без первого слова
     */
    public String getArguments(String input) {
        return input.substring(input.indexOf(" ") + 1);
    }
    /**
     * Определяет нужную команду, либо выбрасывает ошибку
     * @param input
     */


}
