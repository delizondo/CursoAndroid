package llbeam.myapplication.bo;

/**
 * Created by david on 11/16/16.
 */

public class MyContact {

    private String mId;

    private String mName;

    private String mPhone;

    public MyContact(String name, String phone, String id) {
        mName = name;
        mPhone = phone;
        mId = id;
    }


    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }
}
