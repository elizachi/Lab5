package dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import source.HumanBeing;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/**
 * Класс, который реализует десериализацию xml
 */
public class DAODeserialize {
    HumanBeing[] humanBeings;
    private static String directory;

    public DAODeserialize() {}

    /**
     * метод, устанавливающий директорию файла HumanCollection.xml
     * @throws IOException
     */

    public Deque<HumanBeing> deserialize() throws IOException {
        Deque<HumanBeing> deque = new ArrayDeque<>();
        Collections.addAll(deque, humanBeings);
        return deque;
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

    public void setHumanBeings(HumanBeing[] humanBeings) {
        this.humanBeings = humanBeings;
    }
}
