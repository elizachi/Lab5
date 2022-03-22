package service;

import dao.ArrayDequeDAO;
import dao.DAO;
import source.HumanBeing;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    private DAO arrayDequeDAO = new ArrayDequeDAO();
    XmlMapper xmlMapper = new XmlMapper();
    private static final String directory = System.getenv().get("DAO_COLLECTION_FILEPATH");

    /**
     * Сохранение коллекции в файл
     * @param fileName - имя файла
     */
    public void saveToFile() throws IOException, JsonProcessingException {
        String path = directory + "humanBeings.xml";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            BufferedOutputStream output = new BufferedOutputStream(fileOutputStream);
            //xmlMapper.writeValue(output, arrayDequeDAO);
            String xml = xmlMapper.writeValueAsString(output, arrayDequeDAO);
        } catch (IOException, JsonProcessingException e) {
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
            return;
        }
    }

    private static DAO get(String fileName) throws IOException, JsonProcessingException {
        String filepath = directory + fileName;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             FileInputStream fileInputStream = new FileInputStream(filepath);
             BufferedInputStream inputStream = new BufferedInputStream(fileInputStream)) {

            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            return sb.toString();
            int nextByte;
            while ((nextByte = inputStream.read()) != -1) {
                bos.write((char) nextByte);
            }
            String input = bos.toString();
            return input;
        } catch (IOExceprtion, JsonProcessingException e) {
            System.err.print("Возникли какие-то ошибки с файлом.");
            return;
        }
    }
}
