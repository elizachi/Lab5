package others;

import dao.DAOSerialize;
import source.Car;
import source.Coordinates;
import source.HumanBeing;
import source.Mood;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class testMain {
    public static void main(String[] args) throws IOException {
        Deque<HumanBeing> humanBeings = new ArrayDeque<>();
        DAOSerialize daoSerialize = new DAOSerialize(humanBeings);
        Coordinates coordinates = new Coordinates(5, Float.parseFloat("5.00"));
        Car car = new Car("ew", false);
        HumanBeing Petya = new HumanBeing("petya", "sss", Long.parseLong("5"), 5,
        false, false, coordinates, Mood.GLOOM, car);
        humanBeings.add(Petya);


        daoSerialize.serialize();
    }
}
