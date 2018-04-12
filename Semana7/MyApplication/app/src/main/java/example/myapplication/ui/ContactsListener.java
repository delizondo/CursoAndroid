package example.myapplication.ui;

import java.util.List;

import example.myapplication.bo.MyContact;

/**
 * Created by david on 11/16/16.
 */

public interface ContactsListener {

    void onContactsLoaded(List<MyContact> list);

}
