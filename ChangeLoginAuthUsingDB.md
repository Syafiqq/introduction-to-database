# Langkah 9 Rubah Proses Authentikasi dengan menggunakan DB

Buat variabel `dbHelper` di block class `Login Activity`
```
    private DBOpenHelper helper;
```

Instansiasi variabel helper pada proses `onCreate`
```
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ...
        this.helper = new DBOpenHelper(this);

        super.findViewById(R.id.l_login).setOnClickListener(new View.OnClickListener()
        ...
    }
```

Tutup koneksi database pada saat system memanggil fungsi `onDestroy`
```
    @Override protected void onDestroy()
    {
        super.onDestroy();
        this.helper.close();
    }
```

Buat object `UserPojo` dengan memanggil fungsi `findByEmailAndPassword` pada `UserDao` pada fungsi `onLoginClick`
```
    private void onLoginClick(View v)
    {
        ...
        String passwordText = ((EditText) super.findViewById(R.id.l_password)).getText().toString();
        UserPojo user = UserDao.findByEmailAndPassword(this.helper, emailText, passwordText);
        if(emailText.contentEquals("admin@admin.com") && passwordText.contentEquals("secret"))
        ...
    }
```

Ubah proses pengecekan menjadi
```
    private void onLoginClick(View v)
    {
        ...
        UserPojo user = UserDao.findByEmailAndPassword(this.helper, emailText, passwordText);
        if(user != null)
        {
        ...
    }
```

Proses Login dapat kita perkaya dengan melakukan pengecekan peran
```
    private void onLoginClick(View v)
    {
        ...
        UserPojo user = UserDao.findByEmailAndPassword(this.helper, emailText, passwordText);
        if(user != null)
        {
            if(user.getRole().contentEquals("admin"))
            {
                super.startActivity(new Intent(this, AdminDashboardActivity.class));
            }
            else
            {
                Toast.makeText(this, "Selamat Datang Client", Toast.LENGTH_SHORT).show();
            }
        }
        ...
    }
```