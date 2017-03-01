package dictionary.com.myapplication3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText address;
    private RadioGroup type;
    private RadioGroup discount;
    private Button save;
    private Button listButton;
    ListView list;
    List<Restaurant> model = new ArrayList<>();
    RestaurantAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save     = (Button)findViewById(R.id.save);
        name     = (EditText)findViewById(R.id.nameTextField);
        address  = (EditText)findViewById(R.id.addressTextField);
        type     = (RadioGroup)findViewById(R.id.type);
        discount = (RadioGroup)findViewById(R.id.discount);
        //listButton = (Button)findViewById(R.id.restaurant);
        list = (ListView)findViewById(R.id.restaurant);
        // adapter=new ArrayAdapter<Restaurant>(this,android.R.layout.simple_list_item_1,model);
        adapter = new RestaurantAdapter();
        list.setAdapter(adapter);
        saveButton ();
        //listButton();
    }

    private void saveButton (){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant r = new Restaurant();

                r.setName(name.getText().toString());
                r.setAddress(address.getText().toString());
                switch (type.getCheckedRadioButtonId()){
                    case R.id.take_out:
                        r.setType("Take-Out");
                        break;
                    case R.id.sit_down:
                        r.setType("Sit-Down");
                        break;
                    case R.id.delivery:
                        r.setType("Delivery");
                        break;
                    default:
                        //do nothing
                }
                switch (discount.getCheckedRadioButtonId()){
                    case R.id.zero:
                        r.setDiscount("");
                        break;
                    case R.id.small:
                        r.setDiscount("25%");
                        break;
                    case R.id.medium:
                        r.setDiscount("50%");
                        break;
                    case R.id.big:
                        r.setDiscount("75%");
                        break;
                    default:
                        //do nothing
                }
//                Toast.makeText(MainActivity.this,r.getName().toString()+"\n"+r.getAddress().toString()+"\n"+r.getType().toString()+"\n"+r.getDiscount().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Save Successful",Toast.LENGTH_LONG);
                adapter.add(r);
            }

        });
    }
//    private void listButton() {
//        listButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                String tmp = "";
//                for (int i = 0; i < model.size(); i++){
//                    Restaurant rs = model.get(i);
//                    tmp += "\n"+rs.getName().toString()+","+rs.getAddress().toString();
//                }
//                Toast.makeText(getApplicationContext(),tmp,Toast.LENGTH_LONG).show();
//            }
//        });
//    }
class RestaurantAdapter extends ArrayAdapter<Restaurant>{
    RestaurantAdapter() {
        super(MainActivity.this, android.R.layout.simple_list_item_1, model);
    }
    public View getView (int position, View convertView, ViewGroup parent){
        View row = convertView;
        RestaurantHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.row, parent, false);
            holder = new RestaurantHolder(row);
            row.setTag(holder);
        } else {
            holder = (RestaurantHolder)row.getTag();
        }
        holder.populateFrom(model.get(position));
        if (position %2 ==0) {
            row.setBackgroundColor(Color.BLUE);
        } else {
            row.setBackgroundColor(Color.GREEN);
        }
        return (row);
    }
}
}
