package source;

public class Car implements Comparable {
    private String name; //Поле может быть null
    private boolean cool;

    public Car(String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }

    public Car(boolean cool){
        this.name = null;
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
        int result = this.name.compareTo(car.name);
        if (result == 0){
            result = Boolean.compare(this.cool, car.cool);
        }
        return result;
    }

    private String getStringName(){
        if (getCarName() != null){
            return getCarName() + ", ";
        } else {
            return "";
        }
    }

    @Override
    public String toString(){
        if (getCarCool()){
            return getStringName() + "крутая тачка";
        } else {
            return getStringName() + "среднячок";
        }
    }
}
