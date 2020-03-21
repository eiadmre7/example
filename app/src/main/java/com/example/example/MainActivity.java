package com.example.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text1;
    private TextView text2;
    private EditText text3;
    private Button btn1;
    private Button btnNext;
    private Button btnPlus;
    private Button btnMinus;
    private int textSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.txtView1);
        text2 = (TextView) findViewById(R.id.txtSize);
        text3=(EditText)findViewById(R.id.txtName);
        btn1 = (Button) findViewById(R.id.tbtButon1);
        btnPlus = (Button) findViewById(R.id.button2);
        btnMinus= (Button) findViewById(R.id.button3);
        btnNext= (Button) findViewById(R.id.btnNext);
        textSize=20;
        text2.setText(textSize+"");
        onClick1();
    }

    public void onClick1() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Welcome...");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize++;
                text1.setTextSize(textSize);
                text2.setText(textSize+"");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize--;
                text1.setTextSize(textSize);
                text2.setText(textSize+"");
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=text3.getText().toString();
                Intent iiii=new Intent(getApplicationContext(), Page_2.class);
                iiii.putExtra("key",value);

                startActivity(iiii);
            }
        });
    }
}