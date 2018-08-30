# Langkah 13 Tambah List View dan Button Add pada Admin

1. Tambah Button Add User pada layout
    
2. Tambahkan Recycler View untuk menampung linst pada layout

3. Tambahkan aksi untuk button Add User
    ```
    private void onAddUserClick(View v)
    {
        Toast.makeText(this, "Add User", Toast.LENGTH_SHORT).show();
    }
    ```
    
    ```
    super.findViewById(R.id.l_add_user).setOnClickListener(new View.OnClickListener()
    {
        @Override public void onClick(View v)
        {
            AdminDashboardActivity.this.onAddUserClick(v);
        }
    });
    ```