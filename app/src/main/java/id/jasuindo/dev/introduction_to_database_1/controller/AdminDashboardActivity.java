package id.jasuindo.dev.introduction_to_database_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import id.jasuindo.dev.introduction_to_database_1.R;

public class AdminDashboardActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent message = getIntent();
        Integer userID = message.getIntExtra(LoginActivity.USER_ID, 0);
        setContentView(R.layout.activity_admin_dashboard);
    }
}
