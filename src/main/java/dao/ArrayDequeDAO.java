package dao;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import service.HumanComparator;
import source.HumanBeing;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public final class ArrayDequeDAO implements DAO {
    private static int availableId = 0;
    private final LocalDateTime initDate;
    private ArrayDeque<HumanBeing> humanCollection = new ArrayDeque<>();

    public ArrayDequeDAO() {
        initDate = LocalDateTime.now();
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            DAODeserialize daoDeserialize = xmlMapper.readValue(new File(System.getenv("DAO_COLLECTION_FILEPATH")), DAODeserialize.class);
            humanCollection = daoDeserialize.deserialize();
        } catch (NullPointerException e) {
            System.err.print("Проблема какая-то с Null, у меня лапки.\n");
        } catch (IOException e) {
            System.err.print("Коллекция не получена из файла.\n");
        } finally {
            availableId = getAvailableId() + 1;
        }
    }

    @Override
    public LocalDateTime getInitDate(){
        return initDate;
    }

    @Override
    public void save() throws IOException {
        DAOSerialize daoSerialize = new DAOSerialize(this);
        daoSerialize.serialize();
    }

    @Override
    public void clearCollection() {
        humanCollection.clear();
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
        newHuman.setId(availableId);
        newHuman.setCreationDate(LocalDate.now());
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

    /**
     * Метод для уникальности айди, завязанный на полученной из файла коллекции
     * @return максимальный айди
     */
    @Override
    public int getAvailableId(){
        int id;
        if (humanCollection.isEmpty()) {
            id = 1;
        } else {
        id = getMaxId();
        }
        return id;
    }

    public int getMaxId(){
        ArrayDeque<HumanBeing> cloneCollection = humanCollection.clone();
        Integer[] ids = new Integer[cloneCollection.size()];
        int i = 0;
        int max;
        while (!(cloneCollection.isEmpty())) {
            ids[i] = cloneCollection.poll().getId();
            i++;
        }
        max = Collections.max(Arrays.asList(ids));
        return max;
    }
}
