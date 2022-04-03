package dao;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import source.HumanBeing;

import java.io.*;
import java.util.Deque;
import java.util.Map;

/**
 * Класс, который реализует сериализацию xml
 */
public class DAOSerialize {
    XmlMapper xmlMapper = new XmlMapper();
    private static String directory;
    private Deque<HumanBeing> humanCollection;

    /**
     * метод, устанавливающий директорию файла HumanCollection.xml
     * @throws IOException
     */
    public void setDirectory() throws IOException{
        directory = System.getenv("DAO_COLLECTION_FILEPATH");
    }

    public DAOSerialize(Deque<HumanBeing> humanCollection) {
        this.humanCollection = humanCollection;
        try {
            setDirectory();
        } catch (IOException e) {
            System.err.print("Технические шоколадки - невозможно обратиться к переменной DAO_COLLECTION_FILEPATH.\n");
        }
    }

    public void serialize() throws IOException {
        setDirectory();
        xmlMapper.writeValue(new File(directory), humanCollection);
    }

}
