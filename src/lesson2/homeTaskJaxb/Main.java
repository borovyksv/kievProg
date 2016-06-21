package lesson2.homeTaskJaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";


        //создаем парсер
        Query query = init(request);
        //вывод результата
        print(query);



    }

    private static void print(Query query) {
        for (Rate rate : query.getResults().getRates()) {
            System.out.println(rate);
            System.out.println("----------------------------------");
        }
    }

    private static Query init(String request) {
        Query query = null;
        try (InputStream inputStream = new URL(request).openStream()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            query = (Query) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return query;
    }


}