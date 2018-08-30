# Langkah 12 Mengirimkan User Id dari Login Activity ke Dashboard Activity

### Alur Pada `LoginActivity`
1. Buat data key yang digunakan untuk identifikasi nilai pada saat pengiriman dan pada saat penerimaan, peletakan data key terserah yang terpenting data key ini dapat digunakan di *** Activity Pengirim *** dan *** Activity Penerima ***. Pada Contoh ini data-key diletakkan pada `Login Activity`
 
    ```
    public static final String USER_ID = "id.jasuindo.dev.introduction_to_database_1.controller.LoginActivity.user_id";
    ```
    
2. Keluarkan `live instantiation` dari `Intent` pada block ketika `user == admin` menjadi variable tersendiri
 
    ```
    Intent message = new Intent(this, AdminDashboardActivity.class);
    ```
    
3. Tambahakan data user id dengan data-key sesuai dengan butir nomor 1
 
    ```
    message.putExtra(LoginActivity.USER_ID, user.getId());
    ```
    
4. Gunakan langsung variable `message` pada butir ke 2 pada `startActivity`

    ```
    super.startActivity(message);
    ```

5. Keseluruhan alur activity baru menjadi 

    ```
    Intent message = new Intent(this, AdminDashboardActivity.class);
    message.putExtra(LoginActivity.USER_ID, user.getId());
    super.startActivity(message);
    ```
    
### Alur Pada `AdminDashboardActivity`
  
1. Ambil data intent pada activity tersebut pada fungsi `onCreate`
    
    ```
    Intent message = getIntent();
    ```
    
2. Ambil data user id dengan menggunakan data-key yang telah digunakan sebelumnya

    ```
    userId = message.getIntExtra(LoginActivity.USER_ID, 0);
    ```
    
3. Keseluruhan potongan program pada proses `onCreate` menjadi berikut
    ```
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent message = getIntent();
        this.userId = message.getIntExtra(LoginActivity.USER_ID, 0);
        setContentView(R.layout.activity_admin_dashboard);
    }
    ```
    
### Ulagi Kedua Alur Diatas pada proses Client Login