package lesson2.JSON1.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        FileReader reader = new FileReader("C:\\Users\\user-pc\\IdeaProjects\\progKieb\\src\\lesson2\\JSON1\\json.txt");

        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(reader, Person.class);

        System.out.println("Fullname: "+person.name+" "+person.surname+"\n" +
                "Phone numbers: "+ Arrays.toString(person.phones).substring(1, Arrays.toString(person.phones).length()-1) +"\n" +
                "Sites: "+ Arrays.toString(person.sites).substring(1, Arrays.toString(person.sites).length()-1) +"\n" +
                "Lives in "+person.address.country+" country " +
                "on address: "+person.address.city+", "+person.address.street+" street");
    }
}
