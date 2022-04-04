package dao;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import source.HumanBeing;

import java.io.*;
import java.util.Deque;
import java.util.Map;

/**
 * Класс, который реализует сериализацию xml
 */
public class DAOSerialize {
    private XmlMapper xmlMapper = new XmlMapper();
    private static String directory;
    private DAO dao;
    private HumanBeing[] humanBeings;

    /**
     * метод, устанавливающий директорию файла HumanCollection.xml
     * @throws IOException если вдруг что
     */
    public void setDirectory() throws IOException{
        directory = System.getenv("DAO_COLLECTION_FILEPATH");
    }

    public DAOSerialize(DAO dao) {
        this.dao = dao;
        humanBeings = dao.getAll().toArray(new HumanBeing[0]);
        try {
            setDirectory();
        } catch (IOException e) {
            System.err.print("Технические шоколадки - невозможно обратиться к переменной DAO_COLLECTION_FILEPATH.\n");
        }
    }

    public void serialize() throws IOException {
        setDirectory();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(directory), this);
    }

    public HumanBeing[] getHumanBeings() {
        return humanBeings;
    }
}
