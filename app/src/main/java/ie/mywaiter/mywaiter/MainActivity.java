package ie.mywaiter.mywaiter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;


    public void newOrder(View view){

    Intent startNewActivity = new Intent(this, CreateOrder.class);
    startActivity(startNewActivity);
    Toast.makeText(getApplicationContext(),"Who you are tomorrow begins with what you do today.", Toast.LENGTH_SHORT).show();
    }

    public void tableButton(View view){

        Intent startNewActivity = new Intent(this, TablesActivity.class);
        startActivity(startNewActivity);
        Toast.makeText(getApplicationContext(),"Don’t regret the past, just learn from it.", Toast.LENGTH_SHORT).show();
    }

    public void menuID(View view){

        Intent startNewActivity = new Intent(this, NotesActivity.class);
        startActivity(startNewActivity);
        Toast.makeText(getApplicationContext(),"Believe you can and you’re halfway there.", Toast.LENGTH_SHORT).show();
    }

    //private static int SPLASH_TIME_OUT = 4000;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.RecView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListItem object = new ListItem("New","Order");
        ListItem object1 = new ListItem("View","Orders");
        ListItem object2 = new ListItem("Table","Selection");
        ListItem object3 = new ListItem("Menu","Selection");
        ListItem object4 = new ListItem("Make","Notes");
        ListItem object5 = new ListItem("Restart","Application");
        listItems = new ArrayList<>();

        listItems.add(object);
        listItems.add(object1);
        listItems.add(object2);
        listItems.add(object3);
        listItems.add(object4);
        listItems.add(object5);


        adapter = new MyAdapter(this, listItems);
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
