package dao;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import source.HumanBeing;

import java.io.*;
import java.util.Deque;

/**
 * Класс, который реализует сериализацию и десериализацию xml
 */
public class DAOXml {
    private final DAO arrayDequeDAO;
    private Deque<HumanBeing> humanCollection;
    XmlMapper xmlMapper = new XmlMapper();
    private static final String directory = System.getenv().get("DAO_COLLECTION_FILEPATH");

    public DAOXml(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
    }

    public void serialize() throws IOException {
        xmlMapper.writeValue(new File(directory + "HumanCollection.xml"), arrayDequeDAO.getAll());
    }

    public Deque<HumanBeing> deserialize() throws IOException {
        File file = new File(directory + "HumanCollection.xml");
        String xml = bufferedInputToString(new FileInputStream(file));
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
