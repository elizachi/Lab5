package dao;

import source.HumanBeing;

public interface DAO {
    int add(HumanBeing human);
    void update(int id, HumanBeing human);
//    void delete(int id);
    HumanBeing get(int id);
//    Collection<human_being.HumanBeing> show();
}
