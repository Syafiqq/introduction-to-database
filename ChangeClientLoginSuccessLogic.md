# Langkah 11 Rubah Logika ketika login Sukses

Ubah potongan program ketika login success pada `onLoginClick` pada `Activity Login` menjadi
```
   super.startActivity(new Intent(this, ClientDashboardActivity.class));
```

Sehingga fungsi `onLoginClick` menjadi
```
    private void onLoginClick(View v)
    ...
        if(user.getRole().contentEquals("admin"))
        {
            super.startActivity(new Intent(this, AdminDashboardActivity.class));
        }
        else
        {
            super.startActivity(new Intent(this, ClientDashboardActivity.class));
        }
    ...
```