package com.example.christianmorenomarin.proyectoerik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {

    Button btn_registrar;
    EditText editTextNombres,editTextApellidos,editTextDireccion, editTextTelefono, editTextNomUsuario, editTextPass;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BDusuarios", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btn_registrar = (Button) findViewById(R.id.Btn_registrar);
        editTextNombres = (EditText) findViewById(R.id.Edit_nombres);
        editTextApellidos = (EditText) findViewById(R.id.Edit_apellidos);
        editTextDireccion = (EditText) findViewById(R.id.Edit_direccion);
        editTextTelefono = (EditText) findViewById(R.id.Edit_telefono);
        editTextNomUsuario = (EditText) findViewById(R.id.Edit_usuario);
        editTextPass = (EditText) findViewById(R.id.Edit_contrasena);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.abrirDB();
                helper.insertarRegistro(String.valueOf(editTextNombres.getText()),
                        String.valueOf(editTextApellidos.getText()),
                        String.valueOf(editTextDireccion.getText()),
                        String.valueOf(editTextTelefono.getText()),
                        String.valueOf(editTextNomUsuario.getText()),
                        String.valueOf(editTextPass.getText()));
                helper.cerrarDB();

                Toast.makeText(getApplicationContext(), "Registro en base de datos exitoso",
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(i);

            }
        });
    }
}
