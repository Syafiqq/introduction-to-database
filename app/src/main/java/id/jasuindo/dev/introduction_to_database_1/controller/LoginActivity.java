package id.jasuindo.dev.introduction_to_database_1.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import id.jasuindo.dev.introduction_to_database_1.R;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        if(emailText.contentEquals("admin@admin.com") && passwordText.contentEquals("secret"))
        {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}
