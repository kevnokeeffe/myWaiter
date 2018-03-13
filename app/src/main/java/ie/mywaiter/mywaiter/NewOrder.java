package ie.mywaiter.mywaiter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import Data.DataBaseHandler;
import Model.Order;

public class NewOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        DataBaseHandler db = new DataBaseHandler(this);

        //Logging the count
        //Log.d("DB Count: ", String.valueOf(db.getOrderCount()));
        //Insert orders
       // Log.d("Insert:", "Insertin...");
        //db.addOrder(new Order("Garlic Mushrooms", "Fish of the Day", "Cheesecake", "Coke"));

        // Read Back
        Log.d("Reading", "Reading back orders...");
        List<Order> orderList = db.getAllOrders();

        for(Order c : orderList){
            String log = "ID: "+c.getId()+ " , Starter: " + c.getStarter() + " ,Main: " +c.getMain()
                    +", Desert: "+c.getDesert()+ ", Drink: "+c.getDrink();

            Log.d("Name: ", log);
        }

        //Get one order
       // Order oneOrder = db.getOrder(1);
       // oneOrder.setDrink("Orange");
      //  oneOrder.setMain("Gougons");

        //Update order
       // int newOrder = db.updateOrder(oneOrder);

       // Log.d(" One Order: ", " Updated Row: "
        //        + String.valueOf(newOrder) +
        //        " Starter: " + oneOrder.getStarter() +
         //       " Main: " + oneOrder.getMain() +
         //       " Desert: " + oneOrder.getDesert() +
         //       " Drink: " + oneOrder.getDrink());

/*
        //delete single order
        db.deleteOrder(oneOrder);
*/
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
                Intent menu = new Intent(this, NotesActivity.class);
                startActivity(menu);
                Toast.makeText(getApplicationContext(),"Quality is much better than quantity.", Toast.LENGTH_SHORT).show();
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
