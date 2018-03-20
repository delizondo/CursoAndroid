package example.myapplication.bo;

/**
 * Created by david on 10/31/16.
 */

public class Contact {

    private String mName;

    private String mLastName;

    private String mEmail;

    private String mPhone;


    public Contact(String name, String lastName, String email, String phone) {
        this.mName = name;
        this.mLastName = lastName;
        this.mEmail = email;
        this.mPhone = phone;
    }


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

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getFullName() {
        return mName + " " + mLastName;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
