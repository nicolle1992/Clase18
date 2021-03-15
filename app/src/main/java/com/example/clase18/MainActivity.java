package com.example.clase18;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDB database;
    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText sexo;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.txtNombre);
        apellido = (EditText) findViewById(R.id.txtApellido);
        edad = (EditText) findViewById(R.id.txtEdad);
        sexo = (EditText) findViewById(R.id.txtSexo);

        database = new SQLiteDB(getApplicationContext());

        database.insertarDatos("NICOLLE", "SALINAS", 28, "F");
        ArrayList<Usuario> usuarios = database.seleccionarUsuarios();

        if (usuarios.size() > 0) {
            nombre.setText(usuarios.get(0).getNombre());
            apellido.setText(usuarios.get(0).getApellido());
            edad.setText(Integer.toString(usuarios.get(0).getEdad()));
            sexo.setText(usuarios.get(0).getSexo());
        }

        db = database.abrirBaseDeDatos();



    }
}