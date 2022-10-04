package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {
    TextView  nombre,info,programacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        nombre = (TextView) findViewById(R.id.textView);
        info = (TextView) findViewById(R.id.textView7);
        programacion = (TextView) findViewById(R.id.textView8);
        nombre.setText(intent.getExtras().getString("NombreAp"));
        info.setText(intent.getExtras().getString("generos"));
        programacion.setText(intent.getExtras().getString("MeGustaoNo"));


    }
}