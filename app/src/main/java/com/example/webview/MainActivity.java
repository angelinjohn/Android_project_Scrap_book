package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void login(View view) {
        EditText username = (EditText) findViewById(R.id.editText1);
        EditText password = (EditText) findViewById(R.id.editText2);
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Intent in=new Intent(MainActivity.this,HomePage.class);
            startActivity(in);
        } else {
            //wrong password
        }
    }
}
