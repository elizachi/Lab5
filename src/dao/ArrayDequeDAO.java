package dao;

import service.Generator;
import service.HumanComparator;
import source.HumanBeing;

import java.time.LocalDateTime;
import java.util.*;

public final class ArrayDequeDAO implements DAO {
    private static int availableId = 1;
    private LocalDateTime initDate;
    private final Deque<HumanBeing> humanCollection = new ArrayDeque<>();
    private final Generator generator = new Generator();

    public ArrayDequeDAO() {
        initDate = LocalDateTime.now();
    }

    @Override
    public LocalDateTime getInitDate(){
        return initDate;
    }

    /**
     * Сортировка коллекции
     */
    @Override
    public void sort(){
        HumanBeing[] humanBeingArray = humanCollection.toArray(new HumanBeing[0]);
        Arrays.sort(humanBeingArray, new HumanComparator());
        humanCollection.clear();
        humanCollection.addAll(Arrays.asList(humanBeingArray));
    }

    /**
     * Добавление нового элемента в коллекцию
     * @param newHuman - новый элемент коллекции
     * @return         - id нового элемента коллекции
     */
    @Override
    public int add(HumanBeing newHuman) {
        humanCollection.add(newHuman);
        generator.generateID(newHuman);
        generator.generateCreationDate(newHuman);
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
    }

    @Override
    public void remove(int id) {
        HumanBeing existedHuman = get(id);
        if(existedHuman != null) {
            humanCollection.remove(existedHuman);
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

    @Override
    public Collection<HumanBeing> getAll() {
        return humanCollection;
    }

    @Override
    public HumanBeing show() {
        return humanCollection.peek();
    }

    @Override
    public int size(){
        return humanCollection.size();
    }

    @Override
    public int getAvailableId(){
        return availableId;
    }
}
