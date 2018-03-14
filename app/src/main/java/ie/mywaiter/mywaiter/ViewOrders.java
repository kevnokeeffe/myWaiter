package ie.mywaiter.mywaiter;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.ListViewAdapter;
import Adapter.MyAdapter;
import Data.DataBaseHandler;
import Model.ListItem;
import Model.Order;

public class ViewOrders extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListViewAdapter adapter;
    private List<Order> orderItems;
    DataBaseHandler db;
    private String starter, main, desserts, drinks;

    public void populateListView(){


        //List<Order> cursor = db.getAllOrders();


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DataBaseHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);
        recyclerView = (RecyclerView) findViewById(R.id.orderRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //listView = (ListView) findViewById(R.id.orderList);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,numbers);
        // listView.setAdapter(adapter);

        //listView.setOnItemClickListener(this);
        orderItems = new ArrayList<>();
        Intent intent = getIntent();
        starter = intent.getStringExtra("starter");
        main = intent.getStringExtra("main");
        desserts = intent.getStringExtra("desserts");
        drinks = intent.getStringExtra("drinks");

        for(int i = 0; i < 10; i++){
            Order meals = new Order(starter, main, desserts, drinks);
            orderItems.add(meals);
        }
        adapter = new ListViewAdapter(this, orderItems);
        recyclerView.setAdapter(adapter);
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
