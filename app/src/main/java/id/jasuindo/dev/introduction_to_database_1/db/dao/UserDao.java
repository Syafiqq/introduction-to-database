package id.jasuindo.dev.introduction_to_database_1.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import id.jasuindo.dev.introduction_to_database_1.db.pojo.UserPojo;
import java.util.LinkedList;
import java.util.List;

/**
 * This introductiontodatabase1 project created by :
 * Name         : IT Dev
 * Date / Time  : 30 Agustus 2018, 11:04.
 * Email        : jasuindo.co.id
 */
public class UserDao
{
    public static List<Long> insert(SQLiteOpenHelper helper, UserPojo... users)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        return insert(db, users);
    }

    public static List<Long> insert(SQLiteDatabase db, UserPojo... users)
    {
        List<Long> records = new LinkedList<>();

        ContentValues content = new ContentValues();
        for(UserPojo user : users)
        {
            content.put("email", user.getEmail().toLowerCase());
            content.put("username", user.getUsername());
            content.put("role", user.getRole());
            content.put("password", user.getPassword());
            records.add(db.insert("users", null, content));
        }
        return records;
    }

    public static List<UserPojo> readAll(SQLiteOpenHelper helper)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        return readAll(db);
    }

    public static List<UserPojo> readAll(SQLiteDatabase db)
    {
        List<UserPojo> records = new LinkedList<>();
        String query = "SELECT id, username, role, email, password FROM users";
        Cursor cursor = db.rawQuery(query, new String[] {});
        if(cursor.moveToFirst())
        {
            do
            {
                UserPojo user = new UserPojo(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("username")),
                        cursor.getString(cursor.getColumnIndex("role")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("password")));

                records.add(user);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return records;
    }

    public static UserPojo findByEmailAndPassword(SQLiteOpenHelper helper, String email, String password)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        return findByEmailAndPassword(db, email, password);
    }

    public static UserPojo findByEmailAndPassword(SQLiteDatabase db, String email, String password)
    {
        UserPojo record = null;
        String query = "SELECT id, username, role, email, password FROM users where email = ? and password = ?";
        final Cursor cursor = db.rawQuery(query, new String[] {email, password});

        if(cursor.moveToFirst())
        {
            do
            {
                record = new UserPojo(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("username")),
                        cursor.getString(cursor.getColumnIndex("role")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("password")));
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return record;
    }
}
