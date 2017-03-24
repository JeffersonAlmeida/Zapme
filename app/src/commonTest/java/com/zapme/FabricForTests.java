package com.zapme;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zapme.model.Contact;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class FabricForTests {

    private static final String jsonTwoContacts = "[\n" +
            "\n" +
            "\t{\n" +
            "\n" +
            "\t\t\"imageUrl\": \"https://thumbs.dreamstime.com/x/grupo-de-pessoas-feliz-21562670.jpg\",\n" +
            "\t\t\"name\": \"GrupoDePessoas\",\n" +
            "\t\t\"shortDescription\": \"Grupo de Pessoas\"\n" +
            "\n" +
            "\n" +
            "\t},\n" +
            "\n" +
            "\t{\n" +
            "\n" +
            "\t\t\"imageUrl\": \"https://thumbs.dreamstime.com/x/grupo-de-pessoas-feliz-21562670.jpg\",\n" +
            "\t\t\"name\": \"GrupoDePessoas\",\n" +
            "\t\t\"shortDescription\": \"Grupo de Pessoas\"\n" +
            "\n" +
            "\n" +
            "\t}\n" +
            "\n" +
            "]";

    public static List<Contact> getContactsListFromJson(){

        Type listType = new TypeToken<ArrayList<Contact>>(){}.getType();
        List<Contact> contactList = new Gson().fromJson(jsonTwoContacts, listType);

        return contactList;
    }

    public static Contact getFirstContactFromJson(){

        Type listType = new TypeToken<ArrayList<Contact>>(){}.getType();
        List<Contact> contactList = new Gson().fromJson(jsonTwoContacts, listType);

        return contactList.get(0);
    }


}
