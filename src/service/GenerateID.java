package service;

import human_being.HumanBeing;

import java.util.ArrayDeque;

public class GenerateID {
    public GenerateID(ArrayDeque<HumanBeing> humanCollection, HumanBeing human){
        human.setId(humanCollection.size() + 1);
    }
}