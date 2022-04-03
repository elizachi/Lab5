package dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import source.HumanBeing;

import java.io.*;
import java.util.Deque;
import java.util.Map;

/**
 * Класс, который реализует десериализацию xml
 */
public class DAODeserialize {
    private Deque<HumanBeing> humanCollection;
    XmlMapper xmlMapper = new XmlMapper();
    private static String directory;

    public DAODeserialize(Deque<HumanBeing> humanCollection) {
        this.humanCollection = humanCollection;
    }

    /**
     * метод, устанавливающий директорию файла HumanCollection.xml
     * @throws IOException
     */
    public void setDirectory() throws IOException{
        directory = System.getenv("DAO_COLLECTION_FILEPATH");
    }

    public Deque<HumanBeing> deserialize() throws IOException {
        try {
            setDirectory();
        } catch (IOException e) {
            System.err.print("Технические шоколадки - не получаецца получить директорию файла :(\n");
        }
        File file = new File(directory);
        String xml = bufferedInputToString(new FileInputStream(file));
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.enable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        Deque value = xmlMapper.readValue(xml, humanCollection.getClass());
        return value;
    }

    public String bufferedInputToString(InputStream inputStream) throws IOException{
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        String words = "";
        int i;
        while((i = buffer.read()) != -1) {
            words += (char)i;
        }
        buffer.close();
        return words;
    }
}
