package com.example.christianmorenomarin.proyectoerik;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {

    TextView tv_registrar;
    Button btn_entrar;
    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BDusuarios", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_entrar = (Button) findViewById(R.id.btn_EntrarM);

        btn_entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText editTextUsuarioM = (EditText) findViewById(R.id.mainUsuario);
                EditText editTextPasswordM = (EditText) findViewById(R.id.mainContrasena);

                try {
                    Cursor cursor = helper.ConsultaPassUsuario(editTextUsuarioM.getText().toString(), editTextPasswordM.getText().toString());
                    if(cursor.getCount() > 0){
                        Intent intentEntrar = new Intent(MainActivity.this, Usuario.class);
                        MainActivity.this.startActivity(intentEntrar);
                    }else {
                        Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrecto",
                                Toast.LENGTH_LONG).show();
                    }

                    editTextUsuarioM.setText("");
                    editTextPasswordM.setText("");
                    editTextUsuarioM.findFocus();


                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });


        tv_registrar = (TextView) findViewById(R.id.tv_registrar);

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);

            }
        });
    }
}
