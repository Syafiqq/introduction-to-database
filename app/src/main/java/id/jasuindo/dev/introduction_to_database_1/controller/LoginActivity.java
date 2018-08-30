package id.jasuindo.dev.introduction_to_database_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import id.jasuindo.dev.introduction_to_database_1.R;
import id.jasuindo.dev.introduction_to_database_1.db.DBOpenHelper;
import id.jasuindo.dev.introduction_to_database_1.db.dao.UserDao;
import id.jasuindo.dev.introduction_to_database_1.db.pojo.UserPojo;

public class LoginActivity extends AppCompatActivity
{
    public static final String USER_ID = "id.jasuindo.dev.introduction_to_database_1.controller.LoginActivity.user_id";
    private DBOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.helper = new DBOpenHelper(this);

        super.findViewById(R.id.l_login).setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                LoginActivity.this.onLoginClick(v);
            }
        });
    }

    private void onLoginClick(View v)
    {
        String emailText = ((EditText) super.findViewById(R.id.l_email)).getText().toString();
        String passwordText = ((EditText) super.findViewById(R.id.l_password)).getText().toString();
        UserPojo user = UserDao.findByEmailAndPassword(this.helper, emailText, passwordText);
        if(user != null)
        {
            if(user.getRole().contentEquals("admin"))
            {
                Intent message = new Intent(this, AdminDashboardActivity.class);
                message.putExtra(LoginActivity.USER_ID, user.getId());
                super.startActivity(message);
            }
            else
            {
                Intent message = new Intent(this, ClientDashboardActivity.class);
                message.putExtra(LoginActivity.USER_ID, user.getId());
                super.startActivity(message);
            }
        }
        else
        {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }

    @Override protected void onDestroy()
    {
        super.onDestroy();
        this.helper.close();
    }
}
