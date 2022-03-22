package service;

import dao.ArrayDequeDAO;
import dao.DAO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    private final DAO arrayDequeDAO = new ArrayDequeDAO();
    private static final String directory = System.getenv().get("DAO_COLLECTION_FILEPATH");

    /**
     * Сохранение коллекции в файл
     * @param fileName - имя файла
     */
    public void saveToFile(String fileName){
        String path = directory + fileName;
        try {
            FileOutputStream file = new FileOutputStream(path);
            BufferedOutputStream output = new BufferedOutputStream(file);

            byte[] array = arrayDequeDAO.toString().getBytes(StandardCharsets.UTF_8);
            output.write(array);
            output.close();
        } catch (IOException e) {
            System.err.print("Ошибка!");
        }
    }

    /**
     * Получение коллекции из файла
     * @return коллекция, записанная в файл
     */
    public static DAO getFromFile(){
        try {
            return get("humanBeings.xml");
        } catch (IOException e) {
            System.err.print("Пипец.");
        }
    }

    private static DAO get(String fileName) throws IOException{
        String filepath = directory + fileName;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             FileInputStream fileInputStream = new FileInputStream(filepath);
             BufferedInputStream inputStream = new BufferedInputStream(fileInputStream)) {

            int nextByte;
            while ((nextByte = inputStream.read()) != -1) {
                bos.write((char) nextByte);
            }

            String input = bos.toString();
//            JsonNode node = Xml.parse(input);
//            DragonDAO out = Json.fromJson(node, DragonDAO.class);
            return out;
        }
    }


}
