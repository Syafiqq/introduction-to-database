# Langkah 14 Add Item Layout

1. Tambahkan support untuk image vector pada `build.gradle` level module app
    ```
    android {
        ...
        defaultConfig {
            ...
            vectorDrawables.useSupportLibrary = true
        }
        buildTypes {
            ...
        }
    }
    ```
    
2. Buat image vector baru
    
    Caranya terserah
    
3. Buat resource dengan nama `user_list_data.xml`
    
4. Tambahkan item `listitem` pada layout `recyclerView` untuk menampilkan preview di layout `activity_admin_dashboard`
    ```
    <android.support.v7.widget.RecyclerView
        android:layout_width="0dp"
        ...
        tools:listitem="@layout/user_list_data"/>
    ```