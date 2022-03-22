package service;

import source.HumanBeing;

import java.util.Comparator;

/**
 * Класс-компаратор, обладающий методом сортировки
 */
public class HumanComparator implements Comparator<HumanBeing> {

    public int compare(HumanBeing humanOne, HumanBeing humanTwo) {
        return humanOne.compareTo(humanTwo);
    }

}
