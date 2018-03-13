package ie.mywaiter.mywaiter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.NumberPicker;

public class TablesActivity extends AppCompatActivity {

    //private RadioGroup   paymentMethod;
    //private ProgressBar  progressBar;
    private NumberPicker tablePicker;

//This bellow is the code that controles the number picker and where its buttom press navigates too.
    public void donateButtonPressed (View view)

    {
        int amount = tablePicker.getValue();
       // Log.v("Donate", "Donate Pressed! with amount " + amount);
        //if(amount == 1){
        //    Intent table = new Intent(this, SplashScreen.class);
        //    startActivity(table);
        //   Toast.makeText(getApplicationContext(),"Table 1.", Toast.LENGTH_SHORT).show();
        //}
        //else {
        //    Intent table = new Intent(this, SplashScreen.class);
   // startActivity(table);
       // }
        switch (amount){
            case 1:
                Intent table = new Intent(this, SplashScreen.class);
                startActivity(table);
                Toast.makeText(getApplicationContext(),"Table 1.", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Intent table2 = new Intent(this, SplashScreen.class);
                startActivity(table2);
                Toast.makeText(getApplicationContext(),"Table 2.", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent table3 = new Intent(this, SplashScreen.class);
                startActivity(table3);
                Toast.makeText(getApplicationContext(),"Table 3.", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Intent table4 = new Intent(this, SplashScreen.class);
                startActivity(table4);
                Toast.makeText(getApplicationContext(),"Table 4.", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Intent table5 = new Intent(this, SplashScreen.class);
                startActivity(table5);
                Toast.makeText(getApplicationContext(),"Table 5.", Toast.LENGTH_SHORT).show();
                break;
            default:

        }

   }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        tablePicker  = (NumberPicker) findViewById(R.id.tablePicker);
        tablePicker.setMinValue(0);
        tablePicker.setMaxValue(5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        switch(item.getItemId())
        {
            case R.id.home:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                Toast.makeText(getApplicationContext(),"I intend to live forever. So far, so good.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tableID:
                //table
                Intent table = new Intent(this, TablesActivity.class);
                startActivity(table);
                Toast.makeText(getApplicationContext(),"Whatever you are, be a good one.", Toast.LENGTH_SHORT).show();

                break;

            case R.id.menuID:
                //menu
                Intent menu = new Intent(this, NotesActivity.class);
                startActivity(menu);
                Toast.makeText(getApplicationContext(),"Never, never, never give up.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.newOrder:
                //order
                Intent orders = new Intent(this, CreateOrder.class);
                startActivity(orders);
                Toast.makeText(getApplicationContext(),"Wherever you go, go with all your heart.", Toast.LENGTH_SHORT).show();
                break;

            default:
                //unknown error


        }
        return super.onOptionsItemSelected(item);
    }
}
