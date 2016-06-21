package lesson2.homeTask;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user-pc on 15.06.2016.
 */
@XmlRootElement(name = "train")
@XmlType(propOrder = {"from", "to", "travelDate", "departure"})
public class Train {
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat departureFormatter = new SimpleDateFormat("HH:mm");

    private String from;
    private String to;
    private Date travelDate;
    private Date departure;
    private int id;

    public Train() {
    }

    public Train(String from, String to, String travelDate, String departure) {
        this.from = from;
        this.to = to;
        try {
            this.travelDate = dateFormatter.parse(travelDate);
            this.departure = departureFormatter.parse(departure);

        } catch (ParseException e) {
            e.printStackTrace();

        }

    }

    public Date getComparableDate() {
        Date comparableDate = new Date(travelDate.getTime());
        comparableDate.setHours(departure.getHours());
        comparableDate.setMinutes(departure.getMinutes());
        return comparableDate;
    }

    @Override
    public String toString() {
        return "Train{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", \ndeparture=" + getComparableDate() +
                ", id=" + id +
                '}';
    }

    @XmlJavaTypeAdapter(TravelDate.class)
    public Date getTravelDate() {
        return travelDate;
    }

    @XmlElement(name = "date")
    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    @XmlJavaTypeAdapter(Departure.class)
    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }


}
