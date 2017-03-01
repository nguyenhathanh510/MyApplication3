package dictionary.com.myapplication3;

import android.widget.TextView;

/**
 * Created by Nguyen Ha Thanh on 2/14/2017.
 */

public class Restaurant {
    private String name = "";
    private String address = "";
    private String type = "";
    private String discount = "";

    public String getName()
    {
        return name;
    }
    public void setName (String name)
    {
        this.name = name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }


    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public String getDiscount(){ return discount;}
    public TextView setDiscount(String discount) { this.discount = discount;
        return null;
    }
}
