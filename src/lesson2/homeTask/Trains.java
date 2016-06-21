package lesson2.homeTask;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user-pc on 15.06.2016.
 */
@XmlRootElement(name = "trains")
public class Trains {
    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();
    // поле @trainCounter увеличивается при добавлении нового поезда в список @trains;
    private static int trainCounter=0;

    public Trains() {
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void add(Train train) {
        train.setId(++trainCounter);
        trains.add(train);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
