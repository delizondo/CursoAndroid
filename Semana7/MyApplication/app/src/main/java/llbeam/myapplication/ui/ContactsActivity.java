package llbeam.myapplication.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import llbeam.myapplication.bo.MyContact;
import llbeam.myapplication.R;
import llbeam.myapplication.adapter.DividerDecorator;
import llbeam.myapplication.adapter.MyContactAdapter;


/**
 * Created by david on 11/16/16.
 */

public class ContactsActivity extends AppCompatActivity implements ContactsListener {


    private static final String TAG = ContactsActivity.class.getName();

    private static final int CONTACTS_PERSMISSIONS_CODE = 100;

    private ContactsListener mListener;

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_activity_layout);
        mListener = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        int dividerHeight = getResources().getDimensionPixelSize(R.dimen.divider);
        DividerDecorator dividerDecorator = new DividerDecorator(dividerHeight);
        mRecyclerView.addItemDecoration(dividerDecorator);


        if (hasMarshmallow()) {
            if (hasReadContactsPermission() != PackageManager.PERMISSION_GRANTED) {
                // Need to request permissions
                askForPermissions();
            } else {
                loadContactsWithCellPhone();
            }
        } else {
            loadContactsWithCellPhone();
        }


    }


    private void askForPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                CONTACTS_PERSMISSIONS_CODE);

    }


    private int hasReadContactsPermission() {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(requestCode == CONTACTS_PERSMISSIONS_CODE){
            if( grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                loadContactsWithCellPhone();
            }else{
                Toast.makeText(this, "Permissions Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    private void loadContactsWithCellPhone() {

        List<MyContact> contacts = new ArrayList<>();

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        String selection = ContactsContract.CommonDataKinds.Phone.TYPE + "= ?";

        String[] selectionArgs = {String.valueOf(ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)};

        String sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC";

        Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                Log.d(TAG, contactId + " " + contactName + " " + number);
                contacts.add(new MyContact(contactName, number, contactId));
            }
            cursor.close();
            mListener.onContactsLoaded(contacts);
        }
    }

    @Override
    public void onContactsLoaded(List<MyContact> list) {
        MyContactAdapter adapter = new MyContactAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
    }
}
