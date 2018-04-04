package example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by david on 11/9/16.
 */

public class Contact implements Parcelable {


    private String mName;


    private String mLastName;


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mLastName);
    }

    public Contact() {
    }

    protected Contact(Parcel in) {
        this.mName = in.readString();
        this.mLastName = in.readString();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
