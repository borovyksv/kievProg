package lesson2.homeTaskJaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by user-pc on 19.06.2016.
 */
public class DateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DateTimeFormatter.ofPattern("M/dd/uuuu"));
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
