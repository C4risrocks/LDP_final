package com.example.christianmorenomarin.proyectoerik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.DBLibros;

public class prestamo extends AppCompatActivity {

    Button btn_reglib;
    EditText editTextNombre,editTextTipo,editTextAutor, editTextEditorial, editTextAño, editTextStock;

    DBLibros helper = new DBLibros(this, "DBLibros", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo);

        btn_reglib = (Button) findViewById(R.id.btn_reglib);
        editTextNombre = (EditText) findViewById(R.id.Edit_nombre);
        editTextTipo = (EditText) findViewById(R.id.Edit_tipo);
        editTextAutor = (EditText) findViewById(R.id.Edit_autor);
        editTextEditorial = (EditText) findViewById(R.id.Edit_editorial);
        editTextAño = (EditText) findViewById(R.id.Edit_anio);
        editTextStock = (EditText) findViewById(R.id.Edit_stock);



        btn_reglib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextNombre.getText().toString().matches("") |
                        editTextTipo.getText().toString().matches("") |
                        editTextAutor.getText().toString().matches("") |
                        editTextEditorial.getText().toString().matches("") |
                        editTextAño.getText().toString().matches("") |
                        editTextStock.getText().toString().matches("")){

                    Toast.makeText(getApplicationContext(), "Llena todos los campos",
                            Toast.LENGTH_LONG).show();

                }else{

                    helper.abrirDB();
                    helper.insertarRegistro(String.valueOf(editTextNombre.getText()),
                            String.valueOf(editTextTipo.getText()),
                            String.valueOf(editTextAutor.getText()),
                            String.valueOf(editTextEditorial.getText()),
                            String.valueOf(editTextAño.getText()),
                            String.valueOf(editTextStock.getText()));
                    helper.cerrarDB();

                    Toast.makeText(getApplicationContext(), "Registro en base de datos exitoso",
                            Toast.LENGTH_LONG).show();

                    Intent intentprestamo = new Intent(prestamo.this, MainActivity.class);
                    prestamo.this.startActivity(intentprestamo);


                }

            }


        });
    }
}
