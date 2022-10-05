package com.example.miapp;

import static android.app.PendingIntent.getActivity;

import static com.example.miapp.R.id.datePicker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;



public class MainActivity extends AppCompatActivity {
    EditText nombre, apellido;
    Spinner genero;
    RadioGroup programar;
    Button Enviar, Limpiar;
    CheckBox cb,cb2,cb3,cb4,cb5,cb6;
    RadioButton Si;
    DatePicker nacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.editTextTextPersonName2);
        apellido = (EditText) findViewById(R.id.editTextTextPersonName);
        genero = (Spinner) findViewById(R.id.spinner);
        programar = (RadioGroup) findViewById(R.id.radioGroup);
        Si = (RadioButton) findViewById(R.id.radioButton);
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb6 = (CheckBox) findViewById(R.id.checkBox6);
        Enviar = (Button) findViewById(R.id.button2);
        Limpiar = (Button) findViewById(R.id.button);
        nacimiento = (DatePicker) findViewById(datePicker);

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genero.setAdapter(adapter);
        programar.check(R.id.radioButton);

        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                apellido.setText("");
                genero.setSelection(0,true);
                programar.check(-1);
                cb.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(false);
                cb4.setChecked(false);
                cb5.setChecked(false);
                cb6.setChecked(false);

            }
        });

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fecha = nacimiento.getDayOfMonth()+"/"+(nacimiento.getMonth()+1)+"/"+nacimiento.getYear();
                Intent intent = new Intent(v.getContext() , DisplayMessageActivity.class);
                String NombreAp = "Hola!, mi nombre es "+nombre.getText().toString()+" "+apellido.getText().toString()+".";
                String generos = "Soy "+ genero.getSelectedItem().toString().trim()+", "+"y naci en fecha " + fecha;
                String MeGustaoNo = "No me gusta programar";
                if (Si.isChecked()){
                    MeGustaoNo = "Me gusta programar. Mis lenguajes favoritos son: ";
                    if (cb.isChecked()){
                        MeGustaoNo+="Java, ";
                    }
                    if (cb.isChecked()){
                        MeGustaoNo+="JS, ";
                    }
                    if (cb2.isChecked()){
                        MeGustaoNo+="C/C++, ";
                    }
                    if (cb3.isChecked()){
                        MeGustaoNo+="Python, ";
                    }
                    if (cb4.isChecked()){
                        MeGustaoNo+="Go Land, ";
                    }
                    if (cb5.isChecked()){
                        MeGustaoNo+="C#";
                    }
                    MeGustaoNo+=".";
                }
                intent.putExtra("NombreAp", NombreAp);
                intent.putExtra("generos", generos);
                intent.putExtra("MeGustaoNo", MeGustaoNo);
                startActivity(intent);
                }

        });

    }

}