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

    public ArrayDeque<HumanBeing> deserialize() throws IOException {
        ArrayDeque<HumanBeing> deque = new ArrayDeque<>();
        Collections.addAll(deque, humanBeings);
        return deque;
    }

    public void setHumanBeings(HumanBeing[] humanBeings) {
        this.humanBeings = humanBeings;
    }
}
