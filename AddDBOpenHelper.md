# Langkah 2 Membuat Database Open Helper

Sama layaknya seperti Activity cara membuat database sudah diatur didalam sisstem android, kita hanya memperluas fugnsi atau prosedur yang telah disediakan oleh sistem, sehingga database dapat tercipta sesuai dengan keinginan.
Kita harus memperluas class `SQLiteOpenHeleper` dalam membuat database. Class ini juga yang akan digunakan sebagai class untuk mengakses database

##### Langkah-Langkah
 1. Buat Class `DBOpenHelper` atau yang lain
 
     ```
     public class DBOpenHelper
     {
     
     }
     ```
     
 2. Perluas class `DBOpenHelper` dengan `SQLiteOpenHelper` dengan keyword `extends`
 
    ```
    public class DBOpenHelper extends SQLiteOpenHelper
    {
    
    }
    ```
    
 3. Maka class akan mendapatkan error, tekan `alt` + `enter` pada nama class. Lalu pilih `implements methods`
    ```
    public class DBOpenHelper extends SQLiteOpenHelper
    {
    
        @Override public void onCreate(SQLiteDatabase db)
        {
            
        }
    
        @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
    
        }
    }
    ```
    
 4. Tambahkan property `DatabaseVersion` dengan tipe integer
    
    Property database Version digunakan untuk men-set versi database kita. ketika kita merubah komponen yang ada database maka nilai pada DatabaseVersion juga harus ditambah, otomatis fungsi onUpgrade akan dijalankan.
    
    ```
    public class DBOpenHelper extends SQLiteOpenHelper
    {
        public static final int DATABASE_VERSION = 1;
    ```
    
 5. Tambahakan propert `DatabaseName` dengan tipe string
    
    Property database name digunakan untuk menamai databasenya. 
    ```
    public class DBOpenHelper extends SQLiteOpenHelper
    {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "database.db";
    ```
    
 6. Buat Constructornya, buat constructor dengan parameter context dan memanggil super constructor
 
    ```
    public class DBOpenHelper extends SQLiteOpenHelper
    {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "database.db";
    
        public DBOpenHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
    ```
 
 7. Buat Query untuk membuat tabel, caranya yaitu buat variable queryCreation dengan tipe String
 
    ```
        private String queryCreation = "";
    ```
    
    Arahkan cursor ke string yang kosong, tekan `alt` + `enter` lalu pilih `inject language or reference` , pilih `RoomSql`, Tekan `alt` + `enter` lagi lalu pilih `edit room sql fragment` . Isikan fragment dengan DDL berikut
    
    ```
    CREATE TABLE users (
     id integer NOT NULL PRIMARY KEY,
     email text NOT NULL UNIQUE,
     role text NOT NULL DEFAULT('employee'),
     username text NOT NULL,
     password text NOT NULL
    );
    ```
    
    sehingga menghasilkan
    
    ```
    private String queryCreation = "CREATE TABLE users (\n" +
            " id integer NOT NULL PRIMARY KEY,\n" +
            " email text NOT NULL UNIQUE,\n" +
            " role text NOT NULL DEFAULT('employee'),\n" +
            " username text NOT NULL,\n" +
            " password text NOT NULL\n" +
            ");";
    ```
    
 8. Gunakan variabel `queryCreation` pada fungsi `onCreate`
    
    Fungsi `onCreate` digunakan untuk membuat database isi dari fungsi tersebut adalah query untuk membuat tabel tabel yang ada pada database tersebut, berikut adalah isi dari fungsi onCreate
    
    ```
    @Override public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(queryCreation);
    }
    ```
    
 9. Lengkapi fungsi `onUpgrade`
 
    Fungsi `onUpgrade` digunakan apabila kita merubah nilai dari versi databasenya. Harapannya adalah kita dapat membuat database baru lagi. Berikut kode nya
    
    ```
    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE users;");
        onCreate(db);
    }
    ```