package lesson2.homeTask;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TravelDate extends XmlAdapter<String, Date> {
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public Date unmarshal(String date) throws Exception {
        return formatter.parse(date);
    }

    public String marshal(Date date) throws Exception {
        return formatter.format(date);
    }
}