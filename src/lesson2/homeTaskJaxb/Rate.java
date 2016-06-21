package lesson2.homeTaskJaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by user-pc on 19.06.2016.
 */
@XmlRootElement(name = "rate")
public class Rate {
    String name;
    float rate;
    LocalDate date;
    LocalTime time;
    float ask;
    float bid;
    public Rate() {
    }

    public Rate(String name, float rate, LocalDate date, LocalTime time, float ask, float bid) {
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "\nКурс валют:\t\t" +
                name +
                "\nТекущий курс:\t" +
                rate +
                "\nВремя:\t\t\t" +
                time +
                " " +
                date +
                "\nПродажа:\t\t" +
                ask +
                "\nПокупка:\t\t" +
                bid;
    }


    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    @XmlElement(name = "Rate")
    public void setRate(float rate) {
        this.rate = rate;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDate getDate() {
        return date;
    }

    @XmlElement(name = "Date")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @XmlJavaTypeAdapter(TimeAdapter.class)
    public LocalTime getTime() {
        return time;
    }

    @XmlElement(name = "Time")
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public float getAsk() {
        return ask;
    }

    @XmlElement(name = "Ask")
    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getBid() {
        return bid;
    }

    @XmlElement(name = "Bid")
    public void setBid(float bid) {
        this.bid = bid;
    }
}
