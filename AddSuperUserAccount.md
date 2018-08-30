# Langkah 4 Tambahkan Super User Account

Super user account dibuat hanya sekali saja yaitu pada saat pembuatan tabel pertama kali sehingga kita dapat memanfaatkan fungi insert pada UserDao

Tambahkan baris berikut untuk menambahkan super user pada fungsi onCreate pada `DBOpenHelper`

```
UserDao.insert(db, new UserPojo(null, "admin", "admin", "admin@admin.com", "secret"));
```

Sehingga fungsi `onCreate` menjadi berikut

```
@Override public void onCreate(SQLiteDatabase db)
{
    db.execSQL(queryCreation);
    UserDao.insert(db, new UserPojo(null, "admin", "admin", "admin@admin.com", "secret"));
}
```