package ie.mywaiter.mywaiter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kev on 15/02/2018.
 */

public class Databasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "menu.db";
    public static final String TABLE_NAME = "menu_table.db";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Starter";
    public static final String COL_3 = "Main";
    public static final String COL_4 = "Desert";


    public Databasehelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
