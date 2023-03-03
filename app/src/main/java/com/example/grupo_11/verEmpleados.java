package com.example.grupo_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

import com.example.grupo_11.db.DbEmpleados;
import com.example.grupo_11.entidades.Empleados;

import java.util.InputMismatchException;

public class verEmpleados extends AppCompatActivity {


    EditText  txtDni, txtNombre, txtApellidos, txtTelefono, txtDepartamento, txtLocalidad, txtDireccion, txtEmail, txtHorario;
    Button btnGuarda;

    Empleados empleados;
    int id= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_empleados);


        txtDni = findViewById(R.id.txtDni);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtDepartamento = findViewById(R.id.txtDepartamento);
        txtLocalidad = findViewById(R.id.txtLocalidad);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtEmail = findViewById(R.id.txtEmail);
        txtHorario = findViewById(R.id.txtHorario);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            }else {
                id = extras.getInt("id");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("id");
        }

        DbEmpleados dbEmpleados = new DbEmpleados(verEmpleados.this);
        empleados = dbEmpleados.verEmpleados(id);

        if(empleados!=null){
            txtDni.setText(empleados.getDNI());
            txtNombre.setText(empleados.getNombre());
            txtApellidos.setText(empleados.getApellidos());
            txtTelefono.setText(empleados.getTelefono());
            txtDepartamento.setText(empleados.getDepartamento());
            txtLocalidad.setText(empleados.getLocalidad());
            txtDireccion.setText(empleados.getDireccion());
            txtEmail.setText(empleados.getEmail());
            txtHorario.setText(empleados.getHorario());

            txtDni.setInputType(InputType.TYPE_NULL);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtApellidos.setInputType(InputType.TYPE_NULL);
            txtTelefono.setInputType(InputType.TYPE_NULL);
            txtDepartamento.setInputType(InputType.TYPE_NULL);
            txtLocalidad.setInputType(InputType.TYPE_NULL);
            txtDireccion.setInputType(InputType.TYPE_NULL);
            txtEmail.setInputType(InputType.TYPE_NULL);
            txtHorario.setInputType(InputType.TYPE_NULL);
        }
    }
}