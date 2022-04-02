package source;

public class Coordinates {
    private final int x;
    private final Float y; //Значение поля должно быть больше -188, Поле не может быть null

    public Coordinates(int x, Float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates (" +
                "x = " + x +
                ", y = " + y +
                ')';
    }
}