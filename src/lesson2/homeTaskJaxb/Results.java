package lesson2.homeTaskJaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user-pc on 19.06.2016.
 */

@XmlRootElement(name = "results")
public class Results {
    @XmlElement(name = "rate")
    private List<Rate> rates = new ArrayList<>();

    public List<Rate> getRates() {
        return rates;
    }

    public Results() {
    }

    public void add(Rate rate) {
        rates.add(rate);
    }
}
