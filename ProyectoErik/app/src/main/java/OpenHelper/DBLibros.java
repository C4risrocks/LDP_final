package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class DBLibros extends SQLiteOpenHelper{

    final String query = "create table libro (_Codigo integer primary key autoincrement, " +
            "Nombre text, Tipo text, Autor text, Editorial text, Año integer, Stock integer);";


    public DBLibros(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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

    public void insertarRegistro(String nombre, String tipo,String autor, String editorial, String año, String stock ){

        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("Tipo", tipo);
        valores.put("Autor", autor);
        valores.put("Editorial", editorial);
        valores.put("Año", año);
        valores.put("Stock", stock);
        this.getWritableDatabase().insert("libros", null, valores);

    }

    //Metodo para validar usuario


}
