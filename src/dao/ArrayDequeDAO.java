package dao;

import source.HumanBeing;
import service.Generator;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ArrayDequeDAO implements DAO {
    private static int availableId = 1;
    private final Deque<HumanBeing> humanCollection = new ArrayDeque<>();
    private Generator generator = new Generator();

    /**
     * Добавление нового элемента у коллекцию
     * @param newHuman - новый элемент коллекции
     * @return         - id нового элемента коллекции
     */
    @Override
    public int add(HumanBeing newHuman) {
        humanCollection.add(newHuman);
        generator.generateID(newHuman);
        generator.generateCreationDate(newHuman);
        System.out.print("Ура Ура! Элемент добавлен в коллекцию!\n");
        return availableId++;
    }

    /**
     * Обновление уже существующего элемента коллекции
     * @param id           - айдишник по которому ищем элемент
     * @param updatedHuman - новые параметры для этого элемента
     */
    @Override
    public void update(int id, HumanBeing updatedHuman) {
        HumanBeing existedHuman = get(id);
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
        System.out.print("Ура ура! Элемент обновлён!\n");
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
