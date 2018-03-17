package ie.mywaiter.mywaiter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Data.DataBaseHandler;
import Model.Order;

public class UpdateOrder extends AppCompatActivity {


    Order order ;
    EditText startWidg;
    EditText mainWidg;
    EditText desertWidg;
    EditText drinkWidg;
    Button updateOrder1;
    String starter, main, desert,drink;

    //declare data base
    DataBaseHandler db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_order);


        //initialise database
        db = new DataBaseHandler(this);
        if (getIntent().hasExtra("OrderID")){
            String OrderID = getIntent().getExtras().get("OrderID").toString();
            //converting string to int.
            order = db.getOrder(Integer.parseInt(OrderID));
        }
        //link widgets to strings
        startWidg = findViewById(R.id.starter);
        mainWidg = findViewById(R.id.main);
        desertWidg = findViewById(R.id.desert);
        drinkWidg = findViewById(R.id.drink);
        updateOrder1 = findViewById(R.id.updateOrder);
        //db.addOrder(new Order("Garlic Mushrooms", "Fish of the Day", "Cheesecake", "Coke"));

        if (order!= null){
            startWidg.setText(order.getStarter());
            mainWidg.setText(order.getMain());
            desertWidg.setText(order.getDesert());
            drinkWidg.setText(order.getDrink());

        }

    }


    //when the order button is pressed the string values from the widgets populate the database
    public void updateOrderButtonPressed (View view)
    {
        if(order!=null) {
            order.setStarter(startWidg.getText().toString());
            order.setMain(mainWidg.getText().toString());
            order.setDesert(desertWidg.getText().toString());
            order.setDrink(drinkWidg.getText().toString());
            db.updateOrder(order);
            Toast.makeText(getApplicationContext(),"Order Updated.", Toast.LENGTH_SHORT).show();
            //finish();
            Intent intent = new Intent(UpdateOrder.this, ViewOrders.class);
            startActivity(intent);
        }

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
                Toast.makeText(getApplicationContext(),"No one ever drowned in sweat.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tableID:
                //table
                Intent table = new Intent(this, TablesActivity.class);
                startActivity(table);
                Toast.makeText(getApplicationContext(),"Without hard work, nothing grows but weeds.", Toast.LENGTH_SHORT).show();

                break;

            case R.id.menuID:
                //menu
                //Intent menu = new Intent(this, NotesActivity.class);
                //startActivity(menu);
                Toast.makeText(getApplicationContext(),"Under Construction!!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.newOrder:
                //order
                Intent orders = new Intent(this, CreateOrder.class);
                startActivity(orders);
                Toast.makeText(getApplicationContext(),"Work is not always easy.", Toast.LENGTH_SHORT).show();
                break;

            default:
                //unknown error


        }
        return super.onOptionsItemSelected(item);
    }

}
