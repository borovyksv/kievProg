package lesson2.homeTaskJaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by user-pc on 19.06.2016.
 */
public class TimeAdapter extends XmlAdapter<String, LocalTime> {
    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v.toUpperCase(), DateTimeFormatter.ofPattern("HH:mma"));
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.toString();
    }
}
