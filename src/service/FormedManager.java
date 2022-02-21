package service;

import human_being.Car;
import human_being.Coordinates;
import human_being.HumanBeing;
import human_being.Mood;

public class FormedManager {

    public HumanBeing formed(String arguments) {
        String[] fields = arguments.split(" ");
        for (String field : fields) {
            System.out.print(field + " ");
        }
        return new HumanBeing(
                fields[0],
                fields[1],
                Long.parseLong(fields[2]),
                Integer.parseInt(fields[3]),
                Boolean.parseBoolean(fields[4]),
                Boolean.parseBoolean(fields[5]),
                new Coordinates(Integer.parseInt(fields[6]), Float.parseFloat(fields[7])),
                Mood.valueOf(fields[8].toUpperCase()),
                new Car(fields[9], Boolean.parseBoolean(fields[10]))
        );
    }

}
