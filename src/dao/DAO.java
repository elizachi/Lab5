package dao;

import source.HumanBeing;

import java.time.LocalDateTime;
import java.util.Collection;

public interface DAO {
    int add(HumanBeing human);
    void update(int id, HumanBeing human);
    void remove(int id);
    HumanBeing get(int id);
    Collection<HumanBeing> getAll();
    int size();
    int getAvailableId();
    HumanBeing show();
    void sort();
    LocalDateTime getInitDate();
    void save();
}
