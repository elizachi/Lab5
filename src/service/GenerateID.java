package service;

import source.HumanBeing;

public class GenerateID {
    private static int availableId = 1;

    public GenerateID(HumanBeing human){
        human.setId(availableId++);
    }
}
