package dictionary.com.myapplication3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nguyen Ha Thanh on 2/19/2017.
 */

public class RestaurantHolder {
    private TextView name = null;
    private TextView address = null;
    private ImageView icon = null;
    private ImageView icon_discount = null;

    RestaurantHolder(View row) {
        name = (TextView) row.findViewById(R.id.title);
        address = (TextView) row.findViewById(R.id.address);
        icon = (ImageView) row.findViewById(R.id.icon);
        icon_discount = (ImageView)row.findViewById(R.id.icon_discount);


    }

    void populateFrom(Restaurant r) {
        name.setText(r.getName());
        address.setText(r.getAddress());
        if (r.getType().equals("Sit-Down")) {
            icon.setImageResource(R.drawable.ballgreen);
        } else if (r.getType().equals("Take-Out")) {
            icon.setImageResource(R.drawable.ballred);
        } else {
            icon.setImageResource(R.drawable.ball_yellow);
        }

        if (r.getDiscount().equals("25%")) {
            icon_discount.setImageResource(R.drawable.ballred);
        } else if (r.getDiscount().equals("75%")) {
            icon_discount.setImageResource(R.drawable.ball_yellow);
        } else if (r.getDiscount().equals("50%")) {
            icon_discount.setImageResource(R.drawable.ballgreen);
        }
    }
}
