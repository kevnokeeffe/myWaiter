package ie.mywaiter.mywaiter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CreateOrder extends AppCompatActivity {


    public void createOrder1(View view){

        Intent startNewActivity = new Intent(this, NewOrder.class);
        startActivity(startNewActivity);

    }

    public void viewOrdersButton(View view){

        Intent startNewActivity = new Intent(this, ViewOrders.class);
        startActivity(startNewActivity);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.home:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);

                break;

            case R.id.tableID:
                //table
                Intent table = new Intent(this, TablesActivity.class);
                startActivity(table);


                break;

            case R.id.menuID:
                //menu
                Intent menu = new Intent(this, NotesActivity.class);
                startActivity(menu);

                break;

            case R.id.newOrder:
                //order
                Intent orders = new Intent(this, CreateOrder.class);
                startActivity(orders);

                break;

            default:
                //unknown error


        }
        return super.onOptionsItemSelected(item);
    }
}
