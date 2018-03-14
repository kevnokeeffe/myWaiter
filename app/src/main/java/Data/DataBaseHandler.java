package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Model.Order;
import Utils.Util;
import ie.mywaiter.mywaiter.R;

/**
 * Created by Kev on 22/02/2018.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

private EditText starter;

    EditText listView;


    public DataBaseHandler(Context context) {
        super(context, Util.DATABASE_NAME , null, Util.DATEBASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db){

        //SQL = Structured Query Language
        String CREATE_MENU_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_STARTER + " TEXT,"
                +Util.KEY_MAIN + " TEXT," +Util.KEY_DESERT+ " TEXT,"
                +Util.KEY_DRINK + " TEXT" +")";

        db.execSQL(CREATE_MENU_TABLE);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        //Deletes table
        db.execSQL("DROP TABLE IF EXISTS " +Util.TABLE_NAME);

        //CREATE TABLE AGAIN
        onCreate(db);
    }

    public void addOrder(Order order){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Util.KEY_STARTER, order.getStarter());
        value.put(Util.KEY_MAIN, order.getMain());
        value.put(Util.KEY_DESERT, order.getDesert());
        value.put(Util.KEY_DRINK, order.getDrink());

        // INSEERT TO ROW
        long insertOrThrow = db.insertOrThrow(Util.TABLE_NAME, null, value);
        db.close(); //vlose db connection
    }

    //Get a Order

    public Order getOrder(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query( Util.TABLE_NAME , new String[] {Util.KEY_ID, Util.KEY_STARTER,
        Util.KEY_MAIN, Util.KEY_DESERT, Util.KEY_DRINK}, Util.KEY_ID + "=?"
                ,new String[] {String.valueOf(id)}
                ,null, null, null, null  );

        if (cursor != null )
            cursor.moveToFirst();

        Order order = new Order(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4));

        return order;
    }


    public List<Order> getAllOrders() {

        SQLiteDatabase db = this.getReadableDatabase();
        List<Order> orderList = new ArrayList<>();

        //Select all orders

        String selectAll = "SELECT * FROM " +Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        //Loop through our orders

        if (cursor.moveToFirst()){
            do{
                Order order = new Order();
                order.setId(Integer.parseInt(cursor.getString(0)));
                order.setStarter(cursor.getString(1));
                order.setMain(cursor.getString(2));
                order.setDesert(cursor.getString(3));
                order.setDrink(cursor.getString(4));
                orderList.add(order);
            }while (cursor.moveToNext());
        }

        return orderList;
    }


 //update order

    public int updateOrder(Order order){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_STARTER, order.getStarter());
        values.put(Util.KEY_MAIN, order.getMain());
        values.put(Util.KEY_DESERT, order.getDesert());
        values.put(Util.KEY_DRINK, order.getDrink());

        //update row
        return db.update(Util.TABLE_NAME, values,
                Util.KEY_ID + "=?",
                new String[] {String.valueOf(order.getId())});

    }
    public void deleteOrder(Order order){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?",
                new String[]{String.valueOf(order.getId())});

        db.close();

    }

    //Get Order Count
    public int getOrderCount(){
        String countQuery = "SELECT * FROM " +Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);


        //cursor.close();

        return cursor.getCount();

    }


}
