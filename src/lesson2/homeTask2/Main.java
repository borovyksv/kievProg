package lesson2.homeTask2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    
    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        File xmlFile = new File("C:\\Users\\user-pc\\IdeaProjects\\progKieb\\src\\lesson2\\homeTask2\\1.xml");
        performRequest(request, xmlFile);
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        saxParser.parse(xmlFile, new SaxParser());

    }

    private static void performRequest(String urlStr, File xmlFile) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(xmlFile))) {
            char[] buf = new char[1000000];
            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                writer.write(buf, 0, r);
                writer.flush();
            } while (r > 0);
        } finally {
            http.disconnect();
        }

    }

}