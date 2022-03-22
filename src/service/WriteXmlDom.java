import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import source.Car;
import source.HumanBeing;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteXmlDom3 {

    public static void main(String[] args)
            throws ParserConfigurationException, TransformerException {

        HumanBeing human = new HumanBeing();
        Car car = new Car();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("humanBeing");
        doc.appendChild(rootElement);

        // alternative
        // Attr attr = doc.createAttribute("id");
        // attr.setValue("1001");
        // staff.setAttributeNode(attr);

        Element name = doc.createElement("Name");
        name.setTextContent(human.getName());
        doc.appendChild(name);

        Element soundtrack = doc.createElement("SoundtrackName");
        soundtrack.setTextContent(human.getSoundtrackName());
        doc.appendChild(soundtrack);

        Element minutes = doc.createElement("MinutesOfWaiting");
        minutes.setTextContent(human.getMinutesOfWaiting().toString());
        doc.appendChild(minutes);

        Element speed = doc.createElement("ImpactSpeed");
        speed.setTextContent(String.valueOf(human.getImpactSpeed()));
        doc.appendChild(speed);

        Element hero = doc.createElement("RealHero");
        hero.setTextContent(String.valueOf(human.isRealHero()));
        doc.appendChild(hero);

        Element tooth = doc.createElement("ImpactSpeed");
        tooth.setTextContent(String.valueOf(human.isHasToothpick()));
        doc.appendChild(tooth);

        Element coord = doc.createElement("Coordinates");
        coord.setTextContent(human.getCoordinates().toString());
        doc.appendChild(coord);

        Element mood = doc.createElement("Mood");
        mood.setTextContent(human.getMood().toString());
        doc.appendChild(mood);

        Element mech = doc.createElement("Car");
        Element carName = doc.createElement("Name");
        carName.setTextContent(car.getCarName());
        mech.appendChild(carName);
        Element carCool = doc.createElement("Cool");
        carCool.setTextContent(car.getCarCool().toString());
        mech.appendChild(carCool);
        doc.appendChild(mech);

        // print XML to system console
        writeXml(doc, System.out);

    }

    // write doc to output stream
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}