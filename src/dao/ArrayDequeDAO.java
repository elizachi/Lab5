package dao;

import human_being.HumanBeing;
import service.GenerateID;

import java.util.ArrayDeque;

public class ArrayDequeDAO implements DAO {
    /**
     * ЗДЕСЬ ВСЕ БУДЕТ ПРОСТО ВЫПОЛНЯТЬСЯ БЕЗ ПРОВЕРОК ИЛИ ОБРАБОТКИ КАК ЭТО ЕСТЬ У ЕГОШИНА
     */
    private static int availableId = 1;
    private final ArrayDeque<HumanBeing> humanCollection = new ArrayDeque<>();

    public void update() {
        System.out.print("Update...");
    }
    public void read() {
        System.out.print("Select...");
    }
    public void delete() {
        System.out.print("Delete...");
    }

    /**
     * Добавление нового элемента у коллекцию
     * @param newHuman - новый элемент коллекции
     * @return         - id нового элемента коллекции
     */
    @Override
    public int add(HumanBeing newHuman) {
        humanCollection.add(newHuman);
        new GenerateID(newHuman);
        return availableId++;
    }

    /**
     * Обновление уже существующего элемента коллекции
     * @param id           - айдишник по которому ищем элемент
     * @param updatedHuman - новые параметры для этого элемента
     */
    @Override
    public void update(int id, HumanBeing updatedHuman) {
        HumanBeing existedHuman = get(updatedHuman.getId());
        if(existedHuman != null) {
            existedHuman.setName(updatedHuman.getName());
            existedHuman.setSoundtrackName(updatedHuman.getSoundtrackName());
            existedHuman.setMinutesOfWaiting(updatedHuman.getMinutesOfWaiting());
            existedHuman.setImpactSpeed(updatedHuman.getImpactSpeed());
            existedHuman.setRealHero(updatedHuman.isRealHero());
            existedHuman.setHasToothpick(updatedHuman.isHasToothpick());
            existedHuman.setCoordinates(updatedHuman.getCoordinates());
            existedHuman.setMood(updatedHuman.getMood());
            existedHuman.setCar(updatedHuman.getCar());
        }
    }

    /**
     * Нахождение элемента по id
     * @param id - айдишник нужного элемента
     * @return   - либо null, либо найденный элемент
     */
    @Override
    public HumanBeing get(int id) {
        for(HumanBeing human : humanCollection) {
            if(human.getId() == id) {
                return human;
            }
        }
        return null;
    }
}
