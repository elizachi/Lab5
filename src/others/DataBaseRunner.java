package others;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import service.AskInput;
import service.CommandManager;
import service.ReaderManager;
import source.Car;
import source.HumanBeing;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

public class DataBaseRunner {

    /**
     * Главный класс
     *
     * @param args
     */
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        // Запрос на включение дружественного интерфейса
        AskInput.turnOnFriendly();
        // Включение считывание с консоли
        ReaderManager.turnOnConsole();
        // Определение введённой команды
        CommandManager.whichCommand();

    }
}