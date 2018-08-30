package id.jasuindo.dev.introduction_to_database_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import id.jasuindo.dev.introduction_to_database_1.R;
import id.jasuindo.dev.introduction_to_database_1.db.DBOpenHelper;
import id.jasuindo.dev.introduction_to_database_1.db.dao.UserDao;
import id.jasuindo.dev.introduction_to_database_1.db.pojo.UserPojo;

public class AdminDashboardActivity extends AppCompatActivity
{
    private DBOpenHelper helper;
    private UserPojo user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent message = getIntent();
        Integer userID = message.getIntExtra(LoginActivity.USER_ID, 0);

        this.helper = new DBOpenHelper(this);
        this.user = UserDao.findByID(helper, userID);
        setContentView(R.layout.activity_admin_dashboard);
        super.findViewById(R.id.l_add_user).setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                AdminDashboardActivity.this.onAddUserClick(v);
            }
        });
    }

    private void onAddUserClick(View v)
    {
        Toast.makeText(this, "Add User", Toast.LENGTH_SHORT).show();
    }

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

    @Override protected void onDestroy()
    {
        super.onDestroy();
        this.helper.close();
    }
}
