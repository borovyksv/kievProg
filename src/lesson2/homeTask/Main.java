package lesson2.homeTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user-pc on 15.06.2016.
 */
public class Main {

    public static void main(String[] args) {

        Trains trains = new Trains();
//        Написать код для добавления новых поездов в существующий XML.
        trains.add(new Train("Kiev", "Donetsk", "17.06.2016", " 18:05")); //подходит под условие задания
        trains.add(new Train("Lviv", "Feodosia", "17.06.2016", " 15:01"));//подходит под условие задания
        trains.add(new Train("Mariupol", "Kiev", "17.06.2016", " 14:59"));
        trains.add(new Train("Alchevsk", "Donetsk", "17.06.2016", " 18:59"));//подходит под условие задания
        trains.add(new Train("Lutsk", "Donetsk", "18.06.2016", " 23:59"));
        trains.add(new Train("Feodosia", "Alchevsk", "12.06.2016", " 19:01"));
        trains.add(new Train("Kirovograd", "Donetsk", "13.06.2016", " 19:05"));
        trains.add(new Train("Nikolaev", "Kiev", "17.06.2016", " 19:01"));


        try {
            File file = new File("D:\\output.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(trains, file);
            marshaller.marshal(trains, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            Есть список поездов, представленный с виде XML.
            trains = (Trains) unmarshaller.unmarshal(file);

            //Вывести на экран информацию о тех поездах, которые
            //отправляются сегодня с 15:00 до 19:00.

            for (Train train : trains.getTrains()) {
                if (Comparator.compare(train.getComparableDate(), "15:00", "19:00")) {
                    System.out.println(train);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}