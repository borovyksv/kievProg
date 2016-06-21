package lesson2.homeTaskJaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by user-pc on 19.06.2016.
 */
@XmlRootElement(name = "query")
public class Query {
    Results results;

    public Results getResults() {
        return results;
    }
    @XmlElement(name = "results")
    public void setResults(Results results) {
        this.results = results;
    }

    public Query() {
    }
}
