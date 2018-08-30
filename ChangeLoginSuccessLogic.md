# Langkah 8 Rubah Logika ketika login Sukses

Ubah potongan program ketika login success pada `onLoginClick` pada `Activity Login` menjadi
```
    super.startActivity(new Intent(this, AdminDashboardActivity.class));
```

Sehingga fungsi `onLoginClick` menjadi
```
    private void onLoginClick(View v)
    {
        String emailText = ((EditText) super.findViewById(R.id.l_email)).getText().toString();
        String passwordText = ((EditText) super.findViewById(R.id.l_password)).getText().toString();
        if(emailText.contentEquals("admin@admin.com") && passwordText.contentEquals("secret"))
        {
            super.startActivity(new Intent(this, AdminDashboardActivity.class));
        }
        else
        {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }
```