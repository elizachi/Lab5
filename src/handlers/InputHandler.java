package handlers;

import java.util.ArrayList;

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
    // TODO заменить конструкцию на регулярные выржанеия
    public String removeSpaces(String input) {
        input = input.trim();
        while(input.contains("  ")) {
            input = input.replace("  ", " ");
        }
        return input;
    }



}
