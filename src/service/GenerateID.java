package service;

import source.HumanBeing;

import java.util.Deque;

public class GenerateID {
    public GenerateID(Deque<HumanBeing> humanCollection, HumanBeing human){
        human.setId(humanCollection.size() + 1);
    }
}