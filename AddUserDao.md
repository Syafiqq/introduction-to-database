# Langkah 3 Membuat UserDao

Dao merupakan kependean dari Data Access Object, yaitu sekumpulan fungsi yang digunakan sebagai penjembatan antara data di database dengan data yang ada di object pada saat runtime. 

##### Langkah-Langkah

 1. Buat Class `UserDao` atau yang lain
 
     ```
    public class UserDao
    {
    }
     ```

 2. Buat fungsi insert data ke database
 
    Buat fungsi static insert dengan parameter SQLiteDatabase dan User Pojo, fungsi tersebut digunakan untuk melakuakn proses insert kedalam database
    
    ```
    public static List<Long> insert(SQLiteDatabase db, UserPojo... users)
    {
    }
    ```
    
    Buat variable records untuk menampung nilai primary id hasil insert
    
    ```
    List<Long> records = new LinkedList<>();
    ```
    
    Buat variable content value untuk menampung nilai yang akan dikirimkan ke database
    
    ```
    ContentValues content = new ContentValues();
    ```
    
    Looping semua user pojo yang ada diparameter untuk dimasukkan kedatabase
    
    ```
    for(UserPojo user : users)
    {
    }

    ```
    
    Isikan Content Value
    
    ```
    for(UserPojo user : users)
    {
        content.put("email", user.getEmail().toLowerCase());
        content.put("username", user.getUsername());
        content.put("role", user.getRole());
        content.put("password", user.getPassword());
    }
    ```
    
    Jalankan proses insert
    
    ```
    for(UserPojo user : users)
    {
        ...
        records.add(db.insert("users", null, content));
    }
    ```
    
    Kembalikan nilai id pada hasil insert
    
    ```
    return records;
    ```
    
    Apabila user hanya memiliki class SQLiteOpenHeler maka kita buatkan pula fungsi insert dengan parameter tersebut
    
    ```
    public static List<Long> insert(SQLiteOpenHelper helper, UserPojo... users)
    {
    }
    ```
    
    Aktifkan fungsi SQLiteDatabase dengan menggunakan fungsi getWritableDatabase, apbila proses nya melakukan proses pegisian ke database maka gunakan `getWritableDatabase`. Apabila hanya membaca saja gunakan `getReadableDatabase`
    
    ```
    final SQLiteDatabase db = helper.getWritableDatabase();
    ```
    
    Karena sudah memiliki tipe data yang sama dengan fungsi insert sebelumnya maka kita tinggal panggil fungsi insert sebelumnya
    
    ```
    return insert(db, users);
    ```
    
    Sehingga keseluruhan fungsi insert seperti berikut 
    
    ```
    public static List<Long> insert(SQLiteOpenHelper helper, UserPojo... users)
    {
        final SQLiteDatabase db = helper.getWritableDatabase();
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
    ```
    
 3. Buat Fungsi ReadALl untuk mengambil semua data user dari database
    
    Buat query yang digunakan untuk melakukan proses `select`
    
    ```
    String query = "SELECT id, username, role, email, password FROM users";
    ```
    
    Buat Penampung hasil dari database
    
    ```
    List<UserPojo> records = new LinkedList<>();
    ```
    
    Eksekusi query tersebut untuk menghasilkan raw data dari database dan dimasukkan kedalam `cursor` (Istilah `iterator` dalam database)
    
    ```
    Cursor cursor = db.rawQuery(query, new String[] {});
    ```
    
    Cek apakah terdapat kembalian dari database (isi database tidak kosong)
    
    ```
    if(cursor.moveToFirst())
    {

    }
    ```
    
    Iterasi semua hasil dari cursor untuk dimasukkan kedalam list user
    
    ```
    if(cursor.moveToFirst())
    {
        do
        {
        }
        while(cursor.moveToNext());
    }
    ```
    
    Buat object user pojo berdasarkan data dari cursor
    
    ```
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
        }
        while(cursor.moveToNext());
    }
    ```
    
    Masukkan data user kedalam list record
    
    ```
    if(cursor.moveToFirst())
    {
        do
        {
            ...
            records.add(user);
        }
        while(cursor.moveToNext());
    }
    ```
    
    Lepaskan semua resource dari cursor
    
    ```
    cursor.close();
    ```
    
    keluarkan hasil record
    
    ```
    return records;
    ```
    
    Berikut adalah kode program secara keseluruhan 
    
    ```
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
    ```

 3. Buat Fungsi FindByEmailAndPassword untuk mengambil user dengan email dan password yang diinginkan
    
    Buat Penampung hasil dari database
    
    ```
    UserPojo record = null;
    ```
    
    Buat query yang digunakan untuk melakukan proses `select`
    
    ```
    String query = "SELECT id, username, role, email, password FROM users where email = ? and password = ?";
    ```
    
    Eksekusi query tersebut untuk menghasilkan raw data dari database dan dimasukkan kedalam `cursor` (Istilah `iterator` dalam database)
    
    ```
    final Cursor cursor = db.rawQuery(query, new String[] {email, password});
    ```
    
    Cek apakah terdapat kembalian dari database (isi database tidak kosong)
    
    ```
    if(cursor.moveToFirst())
    {

    }
    ```
    
    Iterasi semua hasil dari cursor untuk dimasukkan kedalam list user
    
    ```
    if(cursor.moveToFirst())
    {
        do
        {
        }
        while(cursor.moveToNext());
    }
    ```
    
    Buat object user pojo berdasarkan data dari cursor
    
    ```
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
    ```
    
    Lepaskan semua resource dari cursor
    
    ```
    cursor.close();
    ```
    
    keluarkan hasil record
    
    ```
    return record;
    ```
    
    Berikut adalah kode program secara keseluruhan 
    
    ```
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
    ```
    
 5. Tambahkan fungsi lain sesuai dengan kebutuhan