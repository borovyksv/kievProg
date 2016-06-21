package lesson2.homeTask2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by user-pc on 18.06.2016.
 */
public class SaxParser extends DefaultHandler {
    String qName;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("==================================");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("==================================");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.qName = qName;
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (qName) {
            case "Name":
                System.out.println("Курс валют:\t\t"+new String(ch, start, length));
                break;
            case "Rate":
                System.out.println("Текущий курс:\t"+new String(ch, start, length));
                break;
            case "Date":
                System.out.print("Время:\t\t\t"+new String(ch, start, length));
                break;
            case "Time":
                System.out.println(" "+new String(ch, start, length));
                break;
            case "Ask":
                System.out.println("Продажа:\t\t"+new String(ch, start, length));
                break;
            case "Bid":
                System.out.println("Покупка:\t\t"+new String(ch, start, length));
                break;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("rate"))System.out.println("----------------------------------");
    }
}
