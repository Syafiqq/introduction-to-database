package id.jasuindo.dev.introduction_to_database_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import id.jasuindo.dev.introduction_to_database_1.R;
import id.jasuindo.dev.introduction_to_database_1.db.DBOpenHelper;
import id.jasuindo.dev.introduction_to_database_1.db.dao.UserDao;
import id.jasuindo.dev.introduction_to_database_1.db.pojo.UserPojo;

public class ClientDashboardActivity extends AppCompatActivity
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
        setContentView(R.layout.activity_client_dashboard);
    }

    @Override protected void onDestroy()
    {
        super.onDestroy();
        this.helper.close();
    }
}
