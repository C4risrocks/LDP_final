package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by christianmorenomarin on 12/12/17.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper{


    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "create table usuarios (_ID interger primary key autoincrement, " +
                "Nombres text, Apellidos text, Direccion text, Telefono text, Nombre_Usuario, Password);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    //Metodo que permite abrir la base de datos.

    public void abrirDB(){
        this.getWritableDatabase();
    }

    //Método para cerrar la base de datos.

    public  void cerrarDB(){
        this.close();
    }

    //Método que inserta registros en la tabla usuarios.

    public void insertarRegistro(String nombres, String apellidos, String direccion, String telefono, String nom_usuario, String password ){

        ContentValues valores = new ContentValues();
        valores.put("Nombres",nombres);
        valores.put("Apellidos",apellidos);
        valores.put("Direccion",direccion);
        valores.put("Telefono",telefono);
        valores.put("Nombre_Usuario",nom_usuario);
        valores.put("Password", password);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }

}
