
package xmlsax;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XmlSax {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sax = spf.newSAXParser();
        sax.parse("sweets.xml", new DefaultHandler() {

            String currentElement;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                super.startElement(uri, localName, qName, attributes);
                this.currentElement = qName;
            }

            @Override
            public void characters(char ch[], int start, int length) {
                if ("price".equals(currentElement)) {
                    System.out.println("The price is: " + new String(ch, start, length).trim());
                }
            }
            
            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                super.endElement(uri, localName, qName);
                this.currentElement = null;
            }
  
        });
    }

}
