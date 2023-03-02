package com.example.grupo_11.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.grupo_11.entidades.Empleados;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DbEmpleados extends DbHelper {

    Context context;

    public DbEmpleados(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarEmpleado (String DNI,String nombre, String apellidos, int telefono,
                                 String departamento, String localidad, String direccion,
                                 String email, String horario){

        long id = 0;

        try {

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("DNI", DNI);
            values.put("nombre", nombre);
            values.put("apellidos", apellidos);
            values.put("telefono", telefono);
            values.put("departamento", departamento);
            values.put("localidad", localidad);
            values.put("direccion", direccion);
            values.put("email", email);
            values.put("horario", horario);

            id = db.insert(TABLE_EMPLEADOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Empleados> mostrarEmpleados(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();
        Empleados empleados = null;
        Cursor cursorEmpleados = null;

        cursorEmpleados = db.rawQuery("SELECT * FROM " + TABLE_EMPLEADOS, null);

        if(cursorEmpleados.moveToFirst()){
            do{
                empleados = new Empleados();
                empleados.setDNI(cursorEmpleados.getString(0));
                empleados.setNombre(cursorEmpleados.getString(1));
                empleados.setApellidos(cursorEmpleados.getString(2));
                empleados.setTelefono(cursorEmpleados.getString(3));
                empleados.setDepartamento(cursorEmpleados.getString(4));
                empleados.setLocalidad(cursorEmpleados.getString(5));
                empleados.setDireccion(cursorEmpleados.getString(6));
                empleados.setEmail(cursorEmpleados.getString(7));
                empleados.setHorario(cursorEmpleados.getString(8));

                listaEmpleados.add(empleados);
            } while (cursorEmpleados.moveToNext());
        }

        cursorEmpleados.close();
        return listaEmpleados;
    }

}
