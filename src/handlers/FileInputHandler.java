package handlers;

import java.io.*;
import java.util.Scanner;

public class FileInputHandler extends InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    StringBuilder builder = new StringBuilder();
    /**
     * Переопределённый метод для считывания с файла, проверяющий ошибки
     * @return строки указанного файла
     */
    @Override
    public String read() {

        builder.delete(0, builder.length());
        String input = removeSpaces(scanner.nextLine());
        if(input.isEmpty()) {
            throw new RuntimeException("Необходимо указать путь к файлу.");
        }
        File file = new File(input);

        try {
            FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);

            int i;
            while ((i = bufferedInput.read()) != -1) {
                builder.append((char) i);
            }

            bufferedInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Нужного файла не обнаружено.");
        } catch (IOException e){
            System.out.println("Возникла техническая шоколадка. Пожалуйста, повторите попытку.");
        }

        return builder.toString();
    }
}
