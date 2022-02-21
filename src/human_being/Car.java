package human_being;

public class Car implements Comparable {
    private String name; //Поле может быть null
    private boolean cool;

    public Car(String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }

    Car(boolean cool){
        this.name = null;
        this.cool = cool;
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        int result = this.name.compareTo(car.name);
        if (result == 0){
            result = Boolean.compare(this.cool, car.cool);
        }
        return result;
    }
}
