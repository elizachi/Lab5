package dao;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
        directory = System.getenv().get("DAO_COLLECTION_FILEPATH");
        if (directory == null) {
            ProcessBuilder processBuilder = new ProcessBuilder();
            Map environment = processBuilder.environment();
            String path = File.pathSeparator + "HumanCollection" + File.pathSeparator + "HumanCollection.xml";
            File file = new File(path);
            file.createNewFile();
            environment.put("DAO_COLLECTION_FILEPATH", path);
        }
    }

    public Deque<HumanBeing> deserialize() throws IOException {
        try {
            setDirectory();
        } catch (IOException e) {
            System.err.print("Технические шоколадки - не получаецца создать коллекцию :(\n");
        }
        File file = new File(directory);
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
