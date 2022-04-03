package others;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

        Deque<HumanBeing> humanBeings = new ArrayDeque<>();
        //DAOSerialize daoSerialize = new DAOSerialize();
        DAODeserialize daoDeserialize = new DAODeserialize(humanBeings);

        Coordinates coordinates = new Coordinates(5, Float.parseFloat("5.00"));
        Car car = new Car("ew", false);
        HumanBeing Petya = new HumanBeing("stepa", "sss", Long.parseLong("5"), 5,
        false, false, coordinates, Mood.GLOOM, car);
        Petya.setCreationDate(LocalDate.now());

        humanBeings = daoDeserialize.deserialize();
        humanBeings.add(Petya);
        //daoSerialize.serialize();
        System.out.println(humanBeings);
    }
}
