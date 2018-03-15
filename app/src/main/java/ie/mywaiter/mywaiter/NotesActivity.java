package ie.mywaiter.mywaiter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NotesActivity extends AppCompatActivity {


private Button saveButton;
private EditText enterMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        saveButton = (Button) findViewById(R.id.save);
        enterMessage = (EditText) findViewById(R.id.menuText);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!enterMessage.getText().toString().equals("")){

                    String message = enterMessage.getText().toString();
                    writeToFile(message);
                }else{
                    //do nothing
                }

            }
        });
        try{
          if(readFromFile() !=null) {

              enterMessage.setText(readFromFile());
          }
        } catch (IOException e){
            e.printStackTrace();
        }

    }


    private void writeToFile(String message){

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todolist.txt",
                    Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String readFromFile() throws IOException {
        String result = "";

        InputStream inputStream = openFileInput("todolist.txt");

        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((tempString = bufferedReader.readLine()) != null){

                stringBuilder.append(tempString);
            }

            inputStream.close();
            result = stringBuilder.toString();
        }

        return result;
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
                Toast.makeText(getApplicationContext(),"Fill what’s empty. Empty what’s full.", Toast.LENGTH_SHORT).show();
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
