package others;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.ArrayDequeDAO;
import dao.DAODeserialize;
import dao.DAOSerialize;
import source.Car;
import source.Coordinates;
import source.HumanBeing;
import source.Mood;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class testMain {
    public static void main(String[] args) throws IOException {

        ArrayDequeDAO humanBeings = new ArrayDequeDAO();

        Coordinates coordinates = new Coordinates(5, Float.parseFloat("5.00"));
        Car car = new Car("ew", false);
        HumanBeing Petya = new HumanBeing("stepa", "sss", Long.parseLong("5"), 5,
                false, false, coordinates, Mood.GLOOM, car);
        Petya.setCreationDate(LocalDate.now());

        humanBeings.add(Petya);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        DAOSerialize daoSerialize = new DAOSerialize(humanBeings);
        daoSerialize.serialize();

        DAODeserialize daoDeserialize = xmlMapper.readValue(new File(System.getenv("DAO_COLLECTION_FILEPATH")), DAODeserialize.class);
        Deque deque = daoDeserialize.deserialize();
        System.out.println(deque);
    }
}
