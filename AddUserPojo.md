# Langkah 1 Membuat User Pojo

Pojo merupakan kepanjangan dari Plain Old Java Object, yaitu objek yang hanya dapat digunakan sebagai data holder saja. jadi tida ada fungsi lain pada class tersebut hanya getter, setter, equals, hash, dan tostring.
##### Langkah-Langkah
 1. Buat propertinya terlebih dahulu
 
    ```
        public Integer id;
        public String username;
        public String role;
        public String email;
        public String password;
    ```
    mengapa tipe data `int` menggunakan tipe data object `Integer`, hal itu dikarenakan pada database kemungkinan terdapat `null`, sehingga ketika kita menampung data dari database diuasakahn tipe data tersebut mamu menghandle tipe `null`

 2. Membuat Constructor
 
    Membuat constructor dapat dilakukan dengan dua cara yaitu dengan meng-kodingnya secara langsung atau bisa menggunakan `alt` + `insert` lalu pilih `constructor`
    
    ```
        public UserPojo()
        {
        }
    ```
    ```
        public UserPojo(Integer id, String username, String role, String email, String password)
        {
            this.id = id;
            this.username = username;
            this.role = role;
            this.email = email;
            this.password = password;
        }
    ```
 3. Membuat Setter dan Getter
 
    Setter dan Getter digunakan untuk mengisi nilai pada class tersebut ataupun mengambil nilai dari kelas tersebut. Caranya dapat mengkodingnya secara langsung atau  `alt` + `insert` lalu pilih `getter and setter`

    ```
        public Integer getId()
        {
            return id;
        }
    
        public void setId(Integer id)
        {
            this.id = id;
        }
    
        public String getUsername()
        {
            return username;
        }
    
        public void setUsername(String username)
        {
            this.username = username;
        }
    
        public String getRole()
        {
            return role;
        }
    
        public void setRole(String role)
        {
            this.role = role;
        }
    
        public String getEmail()
        {
            return email;
        }
    
        public void setEmail(String email)
        {
            this.email = email;
        }
    
        public String getPassword()
        {
            return password;
        }
    
        public void setPassword(String password)
        {
            this.password = password;
        }
    ```
    
 4. Membuat Fungsi `equals` dan `hashCode`
    
    Fungsi Equals digunakan untuk melakukan komparasi antar object `UserPojo` berdasarkan properti-nya dan juga melakukan `checksum` terhadap projectnya. Caranya dapat mengkodingnya secara langsung atau  `alt` + `insert` lalu pilih `equals and hashCode`
    
    ```
        @Override public boolean equals(Object o)
        {
            if(this == o)
            {
                return true;
            }
            if(!(o instanceof UserPojo))
            {
                return false;
            }
    
            UserPojo userPojo = (UserPojo) o;
    
            if(id != null ? !id.equals(userPojo.id) : userPojo.id != null)
            {
                return false;
            }
            if(username != null ? !username.equals(userPojo.username) : userPojo.username != null)
            {
                return false;
            }
            if(role != null ? !role.equals(userPojo.role) : userPojo.role != null)
            {
                return false;
            }
            if(email != null ? !email.equals(userPojo.email) : userPojo.email != null)
            {
                return false;
            }
            return password != null ? password.equals(userPojo.password) : userPojo.password == null;
        }
    ```
    
    ```
        @Override public int hashCode()
        {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (username != null ? username.hashCode() : 0);
            result = 31 * result + (role != null ? role.hashCode() : 0);
            result = 31 * result + (email != null ? email.hashCode() : 0);
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }
    ```

 5. Membuat fungsi `toString`
    
    Fugnsi `toString` digunakan untuk mencetak object tersebut. Caranya dapat mengkodingnya secara langsung atau  `alt` + `insert` lalu pilih `toString`
    
    ```
        @Override public String toString()
        {
            return "UserPojo{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", role='" + role + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    ```