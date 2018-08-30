package id.jasuindo.dev.introduction_to_database_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import id.jasuindo.dev.introduction_to_database_1.R;
import id.jasuindo.dev.introduction_to_database_1.db.DBOpenHelper;

public class SplashScreenActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        DBOpenHelper helper = new DBOpenHelper(this);
        helper.getWritableDatabase();

        super.findViewById(R.id.l_login).setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                SplashScreenActivity.this.gotoLogin(v);
            }
        });
    }

    private void gotoLogin(View v)
    {
        super.startActivity(new Intent(this, LoginActivity.class));
    }
}
