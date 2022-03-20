package service;

import human_being.HumanBeing;

import java.util.ArrayDeque;

public class GenerateID {
    private static int availableId = 1;

    public GenerateID(HumanBeing human){
        human.setId(availableId++);
    }
}