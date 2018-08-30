package id.jasuindo.dev.introduction_to_database_1.db.pojo;

/**
 * This introductiontodatabase1 project created by :
 * Name         : IT Dev
 * Date / Time  : 30 Agustus 2018, 9:58.
 * Email        : jasuindo.co.id
 */
public class UserPojo
{
    private Integer id;
    private String username;
    private String role;
    private String email;
    private String password;

    public UserPojo()
    {
    }

    public UserPojo(Integer id, String username, String role, String email, String password)
    {
        this.id = id;
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
    }

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

    @Override public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

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
}
