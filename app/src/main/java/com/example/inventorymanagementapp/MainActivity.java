package com.example.inventorymanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText unameText, pswordText;
    private Button loginbutton;
    private TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unameText = findViewById(R.id.userid);
        pswordText = findViewById(R.id.passid);
        loginbutton = (Button) findViewById(R.id.loginbuttonid);
        txtview =(TextView) findViewById(R.id.textviewid);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Uname= unameText.getText().toString();
                String Psword= pswordText.getText().toString();


                Intent intent=new Intent(MainActivity.this,HomePage.class);
                startActivity(intent);

            }
        });

    }
}