package id.jasuindo.dev.introduction_to_database_1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This introductiontodatabase1 project created by :
 * Name         : IT Dev
 * Date / Time  : 30 Agustus 2018, 10:28.
 * Email        : jasuindo.co.id
 */
public class DBOpenHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    private String queryCreation = "CREATE TABLE users (\n" +
            " id integer NOT NULL PRIMARY KEY,\n" +
            " email text NOT NULL UNIQUE,\n" +
            " role text NOT NULL DEFAULT('employee'),\n" +
            " username text NOT NULL,\n" +
            " password text NOT NULL\n" +
            ");";

    public DBOpenHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(queryCreation);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE users;");
        onCreate(db);
    }
}
