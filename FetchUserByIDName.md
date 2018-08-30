# Langkah 12 Mengambil data user dari id nya

1. Buat Fungsi `findById` pada `userDao`
    
    ```
    public static UserPojo findByID(SQLiteOpenHelper helper, Integer id)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        return findByID(db, id);
    }

    public static UserPojo findByID(SQLiteDatabase db, Integer id)
    {
        UserPojo record = null;
        //Todo : Lengkapi Perintah ini
        return record;
    }
    ```

2. Tambahkan feature `DBHelper` pada `AdminDashboardActivity`
   
    ```
    private DBOpenHelper helper;
    ```
    ```
    this.helper = new DBOpenHelper(this);
    ```
    ```
    @Override protected void onDestroy()
    {
        super.onDestroy();
        this.helper.close();
    }
    ```

3. Buat variable user untuk menampung data user

    ```
    private UserPojo user;
    ```

4. Ambil data user dengan memanggil fungsi `findByID` pada `UserDao`  pada fungsi `onCreate`
    
    ```
    this.user = UserDao.findByID(helper, userID);
    ```
    
5. Ganti Tulisan `Welcome Message` pada `Dashboard` dengan nama user apabila ada

    ```
    @Override protected void onStart()
    {
        super.onStart();
        if(this.user == null)
        {
            ((TextView) findViewById(R.id.l_welcome)).setText("Welcome Back");
        }
        else
        {
            ((TextView) findViewById(R.id.l_welcome)).setText("Welcome Back " + this.user.getUsername());
        }
    }
    ```