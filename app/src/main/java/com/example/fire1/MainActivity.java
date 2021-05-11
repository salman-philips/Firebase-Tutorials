package com.example.fire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent()!=null && getIntent().hasExtra("Kral")){
            for(String key:getIntent().getExtras().keySet()) {
                if(key.equalsIgnoreCase("Kral"))
                Toast.makeText(this, "He is " + key + " " + getIntent().getExtras().getString(key), Toast.LENGTH_SHORT).show();
            }
        }
    }
}