package com.example.inventorymanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    private Button logOutbutton;


    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();

    private TableLayout t;

    EditText info1, info2, info3, info4, info5, info6;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        logOutbutton = (Button) findViewById(R.id.logoutbtn);

        logOutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomePage.this,MainActivity.class);
                startActivity(intent);

            }
        });




        info1 = findViewById(R.id.box1);
        info2 = findViewById(R.id.box2);
        info3 = findViewById(R.id.box3);
        info4 = findViewById(R.id.box4);
        info5 =findViewById(R.id.box5);
        info6 = findViewById(R.id.box6);

        btn =findViewById(R.id.buttonid);


        info5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                int subtot =Integer.parseInt(info4.getText().toString());
                int pay = Integer.parseInt(info5.getText().toString());
                int bal= pay-subtot;

                info6.setText(String.valueOf(bal));

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                func();
            }
        });
    }


    public void func()
    {

        int total;
        String prodname= info1.getText().toString();
        int price= Integer.parseInt(info2.getText().toString());
        int qntity= Integer.parseInt(info3.getText().toString());

        total= price * qntity;

        data.add(prodname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(qntity));
        data3.add(String.valueOf(total));

        TableLayout table = (TableLayout) findViewById(R.id.tblayout);
        TableRow r = new TableRow(this);
        TextView txt1 = new TextView(this);
        TextView txt2 = new TextView(this);
        TextView txt3 = new TextView(this);
        TextView txt4 = new TextView(this);

        String total_price;
        int sum = 0;

        for(int i=0; i<data.size();i++)
        {

            String prdname= data.get(i);
            String prdprice= data1.get(i);
            String prd_qnty= data2.get(i);
            total_price= data3.get(i);

            txt1.setText(prdname);
            txt2.setText(prdprice);
            txt3.setText(prd_qnty);
            txt4.setText(total_price);

            sum = sum+ Integer.parseInt(data3.get(i).toString());


        }


        r.addView(txt1);
        r.addView(txt2);
        r.addView(txt3);
        r.addView(txt4);

        table.addView(r);


        info1.setText("");
        info2.setText("");
        info3.setText("");
        info4.setText(String.valueOf(sum));

        info1.requestFocus();



    }
}
