package handlers;

import java.io.*;

public class FileInputHandler extends InputHandler {
    StringBuilder string = new StringBuilder();
    /**
     * Переопределённый метод для считывания с файла
     */
    @Override
    public String read(boolean is) {
        try {
            int length = string.length();
            string.delete(0, length);
            String link = this.toString();
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fileReader);
            // считаем сначала первую строку
            String line = reader.readLine();
            string.append(line);
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                string.append(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, пожалуйста, проверьте указанный путь.");
        } catch (IOException e) {
            System.out.println("Возникла техническая шоколадка. Пожалуйста, повторите попытку.");
        }
        return string.toString();
    }
}
