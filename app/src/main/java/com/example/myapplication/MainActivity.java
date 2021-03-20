package com.example.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    public static final String  EXTRA_NAME = "com.example.myapplication.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
        String editVal = sP.getString("name", "No value as of now");
        textView.setText(editVal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = editText.getText().toString();
                SharedPreferences sP = getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor ed = sP.edit();
                ed.putString("name", val);
                ed.apply();
                textView.setText(val);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                intent.putExtra(EXTRA_NAME, textView.getText());
                startActivity(intent);

            }
        });
    }



}