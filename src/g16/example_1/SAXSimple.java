package g16.example_1;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXSimple {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SimpleHandler contentHendler = new SimpleHandler();
            reader.setContentHandler(contentHendler);
            reader.parse("src\\g16\\example_1\\student.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
