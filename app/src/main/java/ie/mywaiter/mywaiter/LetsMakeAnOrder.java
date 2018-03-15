package ie.mywaiter.mywaiter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import Data.DataBaseHandler;

public class LetsMakeAnOrder extends Activity implements AdapterView.OnItemSelectedListener {
    DataBaseHandler db;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_make_an_order);
        db = new DataBaseHandler(this);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerStarter);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.starter_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        db = new DataBaseHandler(this);
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected


                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
