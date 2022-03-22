package service;

import source.HumanBeing;

import java.time.LocalDate;

/**
 * Класс для генерации айди и даты создания элемента
 */
public class Generator {
    private static int availableId = 1;

    /**
     * Автоматически генерирует айди
     * @param human экземпляр класса, которому устанавливается данное айди
     */
    public void generateID(HumanBeing human){
        human.setId(availableId++);
    }

    /**
     * Автоматически генерирует дату создания экземпляра
     * @param humanBeing экземпляр класса, дата создания которого генерируется
     */
    public void generateCreationDate(HumanBeing humanBeing){
        humanBeing.setCreationDate(LocalDate.now());
    }
}

