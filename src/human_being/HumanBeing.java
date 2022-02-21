package human_being;

import java.time.LocalDate;

public class HumanBeing implements Comparable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно
    // генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick; //Поле может быть null
    private int impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private Long minutesOfWaiting; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null


    public HumanBeing(String name, String soundtrackName, Long minutesOfWaiting, int impactSpeed,
                      boolean realHero, boolean hasToothpick, Coordinates coordinates,
                      Mood mood, Car car) {
        this.name = name;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.impactSpeed = impactSpeed;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.coordinates = coordinates;
        this.mood = mood;
        this.car = car;
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

    public boolean isRealHero() {
        return realHero;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setImpactSpeed(int impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public int getImpactSpeed() {
        return impactSpeed;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setMinutesOfWaiting(Long minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Long getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Mood getMood() {
        return mood;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    // переобределение метода compareTo для сортировки
    @Override
    public int compareTo(Object o) {
        if (o == null){
            return -1;
        }
        if (!(o instanceof HumanBeing)){
            throw new ClassCastException("Несравнимые типы.");
        }
        HumanBeing humanBeing = (HumanBeing) o;
        int result = this.name.compareTo(humanBeing.name);
        if (result == 0) {
            result = Boolean.compare(this.hasToothpick, humanBeing.hasToothpick);
            if (result == 0) {
                result = Integer.compare(this.impactSpeed, humanBeing.impactSpeed);
            }
            if (result == 0) {
                result = this.soundtrackName.compareTo(humanBeing.soundtrackName);
            }
            if (result == 0) {
                result = this.minutesOfWaiting.compareTo(humanBeing.minutesOfWaiting);
            }
            if (result == 0) {
                int ordinalThis = Mood.valueOf(this.mood.toString()).ordinal();
                int ordinalHumanBeing = Mood.valueOf(humanBeing.mood.toString()).ordinal();
                result = Integer.compare(ordinalThis, ordinalHumanBeing);
            }
            if (result == 0) {
                result = this.car.compareTo(humanBeing.car);
            }
        }
        return result;
    }
    // TODO переопределить нормально
    public String toString() {
        System.out.print(name + soundtrackName + minutesOfWaiting + impactSpeed + realHero + hasToothpick +
                coordinates+ mood + car);
        return null;
    }
}
