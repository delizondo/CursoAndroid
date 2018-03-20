package example.myapplication.util;

import java.util.ArrayList;
import java.util.List;

import example.myapplication.bo.Contact;

/**
 * Created by david on 10/31/16.
 */

public class ContactUtil {

    public static List<Contact> createContacts() {
        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Andres", "Barquero", "abarquero@example.com", "2201 0100 ext. 40105"));
        contacts.add(new Contact("Didier", "Corrales", "dcorrales@example.com", "2201 0100 ext 40062"));
        contacts.add(new Contact("Eder", "Coronado", "ecoronado@example.com", "2201 0100 ext 40172"));
        contacts.add(new Contact("Hernan", "Saenz", "hsaenz@example.com", "2201 0100 ext 40005"));
        contacts.add(new Contact("Mariano", "Jiménez", "mjimenez@example.com", "2201 0100 ext 40073"));
        contacts.add(new Contact("Michael", "Hernández", "mhernandez@example.com", "2201 0100 ext 40019"));
        contacts.add(new Contact("Ricardo", "Jarquin", "rjarquin@example.com", "2201 0100 ext 40156"));
        contacts.add(new Contact("Ronny", "Flores", "rflores@example.com", "2201 0100 ext 40024"));
        contacts.add(new Contact("Yohan", "Desanti", "ydesanti@example.com", "2201 0100 ext 40165"));

        return contacts;
    }


}
