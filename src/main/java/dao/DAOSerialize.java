package dao;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.Map;

/**
 * Класс, который реализует сериализацию xml
 */
public class DAOSerialize {
    private final DAO arrayDequeDAO;
    XmlMapper xmlMapper = new XmlMapper();
    private static String directory;

    /**
     * метод, устанавливающий директорию файла HumanCollection.xml
     * @throws IOException
     */
    public void setDirectory() throws IOException{
        directory = System.getenv().get("DAO_COLLECTION_FILEPATH");
        if (directory == null) {
            ProcessBuilder processBuilder = new ProcessBuilder();
            Map environment = processBuilder.environment();
            String path = File.pathSeparator + "HumanCollection" + File.pathSeparator + "HumanCollection.xml";
            environment.put("DAO_COLLECTION_FILEPATH", path);
            setDirectory();
        }
    }

    public DAOSerialize(DAO arrayDequeDAO) {
        this.arrayDequeDAO = arrayDequeDAO;
        try {
            setDirectory();
        } catch (IOException e) {
            System.err.print("Технические шоколадки - не получаецца создать коллекцию :(\n");
        }
    }

    public void serialize() throws IOException {
        xmlMapper.writeValue(new File(directory), arrayDequeDAO.getAll());
    }

}
