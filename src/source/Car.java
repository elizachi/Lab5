package source;

public class Car implements Comparable {
    private String name; //Поле может быть null
    private boolean cool;
    private int result;

    public Car(String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }

    public void setCarName(String name) {
        this.name = name;
    }

    public void setCarCool(boolean cool) {
        this.cool = cool;
    }

    public String getCarName() {
        return name;
    }

    public Boolean getCarCool(){
        return cool;
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        if (name == null) {
            result = Boolean.compare(this.cool, car.cool);
        } else {
            result = this.name.compareTo(car.name);
            if (result == 0) {
                result = Boolean.compare(this.cool, car.cool);
            }
        }
        return result;
    }

    @Override
    public String toString(){
        if (getCarName() != null){
            return getCarName() + ", ";
        }
        if (getCarCool()){
            return "крутая тачка";
        } else {
            return "среднячок";
        }
    }
}
