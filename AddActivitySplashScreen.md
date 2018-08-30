# Langkah 5 BuatActivity Splash Screen

Activity Pertamakali yang digunakan untuk menampilkan logo ataupun melakukan inisialisasi aplikasi untuk pertama kali dapat dinamakan sebagai ***Splash Screen Activity*** 
Adapun file yang berubah sesuai pada commit ini.

Pada Proses `onCreate` ditambahkan proses initialisasi database dengan mengambil DBOpenHelper dan mengaktifkan `getWritableDatabase()`
```
    DBOpenHelper helper = new DBOpenHelper(this);
    helper.getWritableDatabase();
```

Sehingga potongan program onCreate menjadi 
```
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ...
        setContentView(R.layout.activity_splash_screen);
        
        DBOpenHelper helper = new DBOpenHelper(this);
        helper.getWritableDatabase();

        super.findViewById(R.id.l_login).setOnClickListener(new View.OnClickListener()
        ...
    }
```